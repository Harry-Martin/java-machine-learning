package com.harrymartin;

import com.harrymartin.Matrix;

public class Main {

    public static void main(String[] args) {

	    Matrix m1 = new Matrix(new double[][] {
	            {1, 2, 3},
                {4, 5, 6}
	    });

        Matrix m2 = new Matrix(new double[][] {
                {7, 8},
                {9, 10},
                {11, 12}
        });
        Matrix m3 = Matrix.dot(m1, m2);
	    System.out.println(m3);

    }
}
