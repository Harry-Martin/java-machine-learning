package com.harrymartin.ml;

public class Matrix {

    double[][] data;
    int rows, cols;

    // Initialise a [rows:cols] matrix with 0s
    public Matrix(int rows, int cols){
        double[][] data = new double[rows][cols];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                data[i][j] = 0;
            }
        }
        this.data = data;
        this.rows = rows;
        this.cols = cols;
    }


    public Matrix(double[][] data){
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }
    
    
    public String toString(){
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < this.rows; i++) {
            matrix.append("|");
            for (int j = 0; j < this.cols; j++) {
                matrix.append(String.format(" %s ", this.data[i][j]));
            }
            matrix.append("|\n");
        }
        return matrix.toString();
    }


    // Element wise multiplication
    public static Matrix mul(Matrix m1, Matrix m2){
        if(!(m1.rows == m2.rows && m1.cols == m2.cols)) {
            System.out.printf("ERROR: Matrix dimension mismatch ([%d:%d] x [%d:%d])",
                    m1.rows, m1.cols, m2.rows, m2.cols);
            return new Matrix(0, 0);
        }

        Matrix result = new Matrix(m1.rows, m1.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                result.data[i][j] = m1.data[i][j] * m2.data[i][j];
            }
        }
        return result;
    }


    // Scalar multiplication
    public static Matrix mul(Matrix m, double scalar){
        Matrix result = new Matrix(m.rows, m.cols);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result.data[i][j] = m.data[i][j] * scalar;
            }
        }
        return result;
    }


    public static Matrix dot(Matrix m1, Matrix m2){
        Matrix result = new Matrix(m1.rows, m2.cols);
        for (int i = 0; i < result.rows; i++) {
            for (int j = 0; j < result.cols; j++) {
                for (int k = 0; k < m1.cols; k++) {
                    /* sum the products of each element in each row i of m1
                       by the corresponding element in each column j of m2 */
                    result.data[i][j] += m1.data[i][k] * m2.data[k][j];
                }
            }
        }
        return result;
    }
}
