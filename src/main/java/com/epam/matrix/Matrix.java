package com.epam.matrix;

import java.util.Random;

public class Matrix {

    private int mRows;
    private int mColumns;
    private int[][] mValues;

    public Matrix(int rows, int columns) {
        if (rows > 0 && columns > 0) {
            mRows = rows;
            mColumns = columns;
            mValues = new int[rows][columns];
        } else {
            System.out.println("ERROR: The dimension of the matrix can not be a negative number or zero");
        }
    }

    public Matrix(int[][] values) {
        mRows = valuesGetRows(values);
        mColumns = valuesGetColumns(values);
        int[][] v = new int[mRows][mColumns];
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < values[i].length; j++) {
                v[i][j] = values[i][j];
            }
        }
        mValues = v;
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
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mColumns; j++) {
                mValues[i][j] = 0;
            }
        }
    }

    public void fillRandom(int bound) {
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mColumns; j++) {
                mValues[i][j] = new Random().nextInt(bound);
            }
        }
    }

    public Matrix multiply(Matrix matrix) {
        return Matrix.multiply(this, matrix);
    }

    public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
        Matrix matrixResult = new Matrix(matrixA.mRows, matrixB.mColumns);
        if (matrixA.mColumns == matrixB.mRows) {
            for (int i = 0; i < matrixResult.mRows; i++) {
                for (int j = 0; j < matrixResult.mColumns; j++) {
                    for (int k = 0; k < matrixA.mColumns; k++) {
                        matrixResult.mValues[i][j] += matrixA.mValues[i][k] * matrixB.mValues[k][j];
                    }
                }
            }
        } else {
            System.out.println("ERROR: The matrices of this size can not be multiplied");
        }
        return matrixResult;
    }

    public void resize(int rows, int columns) {
        Matrix matrixResult = new Matrix(rows, columns);
        int minRows = Math.min(mRows, rows);
        int minColumns = Math.min(mColumns, columns);
        for (int i = 0; i < minRows; i++) {
            for (int j = 0; j < minColumns; j++) {
                matrixResult.mValues[i][j] = mValues[i][j];
            }
        }
        mRows = rows;
        mColumns = columns;
        mValues = matrixResult.mValues;
    }

    public void printSize() {
        System.out.println("rows: " + mRows);
        System.out.println("columns: " + mColumns);
    }

    public void printValue() {
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mColumns; j++) {
                System.out.format("%5d", mValues[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getRows() {
        return mRows;
    }

    public int getColumns() {
        return mColumns;
    }

}
