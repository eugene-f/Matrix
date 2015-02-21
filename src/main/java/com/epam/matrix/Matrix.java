package com.epam.matrix;

import java.util.Random;

public class Matrix {

    private int rows;
    private int columns;
    private int[][] values;

    public Matrix(int rows, int columns) {
        try {
            this.rows = rows;
            this.columns = columns;
            this.values = new int[rows][columns];
        } catch (NegativeArraySizeException e) {
            System.out.println("ERROR: NegativeArraySizeException");
        }
    }

    public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
        Matrix matrixC = new Matrix(matrixA.rows, matrixB.columns);
        if (matrixA.columns == matrixB.rows) {
            for (int i = 0; i < matrixC.rows; i++) {
                for (int j = 0; j < matrixC.columns; j++) {
                    for (int k = 0; k < matrixA.columns; k++) {
                        matrixC.values[i][j] += matrixA.values[i][k] * matrixB.values[k][j];
                    }
                }
            }
        } else {
            System.out.println("ERROR: matrixA.columns != matrixB.rows");
        }
        return matrixC;
    }

    public void initRandom() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.values[i][j] = new Random().nextInt(16) + new Random().nextInt(16);
            }
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.format("%5d", values[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
