package com.harrymartin;

import com.harrymartin.ml.Activation;
import com.harrymartin.ml.Matrix;
import com.harrymartin.ml.Perceptron;

public class Main {

    public static void main(String[] args) {
        Matrix weights = new Matrix(new double[][]{
                {-0.3, 0.4, -0.4}
        });
        Matrix input = new Matrix(new double[][]{
                {1, 0, 0}
        });

        Perceptron p = new Perceptron(weights, Activation::heaviside_step);
        for (int i = 0; i < 6; i++) {
            System.out.println(p.propagate(input));
            p.epoch(input, 0, 0.25);
            System.out.println(p.weight);
        }

        System.out.println(p.weight);
        System.out.println(p.propagate(input));
    }
}
