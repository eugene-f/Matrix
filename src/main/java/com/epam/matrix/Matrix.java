package com.epam.matrix;

import java.util.Random;

public class Matrix {

    int rows;
    int collums;
    int[][] values;

    public Matrix(int rows, int collums) {
        this.rows = rows;
        this.collums = collums;
        this.values = new int[rows][collums];
    }

    public void init() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collums; j++) {
                this.values[i][j] = new Random().nextInt();
            }
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collums; j++) {
                System.out.println(values[i][j]);
            }
        }
    }

    public Matrix multiplicate(Matrix matrixB) {
        Matrix matrixC = new Matrix(this.rows, matrixB.collums);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrixB.collums; j++) {
                for (int k = 0; k < values.length; k++) {
                    matrixC.values[i][j] = this.values[i][0] * matrixB.values[0][j];
                }
            }
        }

        return matrixC;
    }

}
