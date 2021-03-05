package com.harrymartin.ml;

import java.util.function.DoubleFunction;

public class Perceptron {
    public Matrix weight;
    DoubleFunction<Double> activation;

    public Perceptron(Matrix weight, DoubleFunction<Double> activation){
        this.weight = weight;
        this.activation = activation;
    }

    public double propagate(Matrix input){
        double w_sum = Matrix.sum(Matrix.mul(input, this.weight));
        return activation.apply(w_sum);
    }

    // Fixed Increment Learning
    public void epoch(Matrix input, double expected, double learningRate){
        Matrix error = new Matrix(input.rows, input.cols);
        double output = this.propagate(input);
        if(output > expected){ error = Matrix.neg(input); }
        if(output < expected){ error = input; }
        Matrix deltaWeight = Matrix.mul(error, learningRate);
        this.weight = Matrix.add(deltaWeight, this.weight);
    }
}
