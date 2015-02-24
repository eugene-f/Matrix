package com.epam.matrix;

import java.util.Random;

public class Matrix {

    private int matrixRows;
    private int matrixColumns;
    private int[][] matrixValues;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            System.out.println("ERROR: The dimension of the matrix can not be a negative number or zero");
            // TODO: throw Exception
        } else {
            matrixRows = rows;
            matrixColumns = columns;
            matrixValues = new int[rows][columns];
        }
    }

    public Matrix(int[][] values) {
        matrixRows = valuesGetRows(values);
        matrixColumns = valuesGetColumns(values);
        int[][] v = new int[matrixRows][matrixColumns];
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < values[i].length; j++) {
                v[i][j] = values[i][j];
            }
        }
        matrixValues = v;
    }

    private int valuesGetRows(int[][] values) {
        return values.length;
    }

    private int valuesGetColumns(int[][] values) {
        int valuesColumns = 0;
        for (int i = 0; i < valuesGetRows(values); i++) {
            valuesColumns = Math.max(valuesColumns, values[i].length);
        }
        return valuesColumns;
    }

    public void fillZero() {
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                matrixValues[i][j] = 0;
            }
        }
    }

    public void fillRandom(int bound) {
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                matrixValues[i][j] = new Random().nextInt(bound);
            }
        }
    }

    public Matrix multiply(Matrix matrix) {
        return Matrix.multiply(this, matrix);
    }

    public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
        Matrix matrixResult = new Matrix(matrixA.matrixRows, matrixB.matrixColumns);
        if (matrixA.matrixColumns == matrixB.matrixRows) {
            for (int i = 0; i < matrixResult.matrixRows; i++) {
                for (int j = 0; j < matrixResult.matrixColumns; j++) {
                    for (int k = 0; k < matrixA.matrixColumns; k++) {
                        matrixResult.matrixValues[i][j] += matrixA.matrixValues[i][k] * matrixB.matrixValues[k][j];
                    }
                }
            }
        } else {
            System.out.println("ERROR: The matrices of this size can not be multiplied");
        }
        return matrixResult;
    }

    public void resize(int rows, int columns) {
        int[][] values = new int[rows][columns];
        int minRows = Math.min(matrixRows, rows);
        int minColumns = Math.min(matrixColumns, columns);
        for (int i = 0; i < minRows; i++) {
            for (int j = 0; j < minColumns; j++) {
                values[i][j] = matrixValues[i][j];
            }
        }
        matrixRows = rows;
        matrixColumns = columns;
        matrixValues = values;
    }

    public void printSize() {
        System.out.println("rows: " + matrixRows);
        System.out.println("columns: " + matrixColumns);
    }

    public void printValue() {
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                System.out.format("%5d", matrixValues[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getMatrixRows() {
        return matrixRows;
    }

    public int getMatrixColumns() {
        return matrixColumns;
    }

}
