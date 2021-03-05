package com.harrymartin;

import com.harrymartin.ml.Activation;
import com.harrymartin.ml.Matrix;
import com.harrymartin.ml.Perceptron;

public class Main {

    public static void main(String[] args) {
        Matrix weights = new Matrix(new double[][]{
                {-0.3, 0.4, -0.4}
        });
        Matrix input00 = new Matrix(new double[][]{
                {1, 0, 0}
        });
        Matrix input01 = new Matrix(new double[][]{
                {1, 0, 1}
        });
        Matrix input10 = new Matrix(new double[][]{
                {1, 1, 0}
        });
        Matrix input11 = new Matrix(new double[][]{
                {1, 1, 1}
        });

        Perceptron p = new Perceptron(weights, Activation::heaviside_step);
        // Train perceptron to recognise AND operation
        for (int i = 0; i < 3; i++) {
            p.epoch(input00, 0, 0.25);
            p.epoch(input01, 0, 0.25);
            p.epoch(input10, 0, 0.25);
            p.epoch(input11, 1, 0.25);
        }
        

        System.out.println(p.weight);
        System.out.println(p.propagate(input00));
        System.out.println(p.propagate(input01));
        System.out.println(p.propagate(input10));
        System.out.println(p.propagate(input11));
    }
}
