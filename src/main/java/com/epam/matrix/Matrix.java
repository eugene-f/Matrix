package com.epam.matrix;

import java.util.Random;

public class Matrix {

    private int rows;
    private int columns;
    private int[][] values;

    public Matrix(int rows, int columns) {
        create(rows, columns);
    }

    public Matrix(int[][] values) {
        rows = valuesGetRows(values);
        columns = valuesGetColumns(values);
        int[][] v = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < values[i].length; j++) {
                v[i][j] = values[i][j];
            }
        }
        this.values = v;
    }

    private void create(int rows, int columns) {
        if (rows > 0 && columns > 0) {
            this.rows = rows;
            this.columns = columns;
            this.values = new int[rows][columns];
        } else {
            System.out.println("ERROR: The dimension of the matrix can not be a negative number or zero");
        }
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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.values[i][j] = 0;
            }
        }
    }

    public void fillRandom(int bound) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.values[i][j] = new Random().nextInt(bound);
            }
        }
    }

    public Matrix multiply(Matrix matrix) {
        return Matrix.multiply(this, matrix);
    }

    public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
        Matrix matrixResult = new Matrix(matrixA.rows, matrixB.columns);
        if (matrixA.columns == matrixB.rows) {
            for (int i = 0; i < matrixResult.rows; i++) {
                for (int j = 0; j < matrixResult.columns; j++) {
                    for (int k = 0; k < matrixA.columns; k++) {
                        matrixResult.values[i][j] += matrixA.values[i][k] * matrixB.values[k][j];
                    }
                }
            }
        } else {
            System.out.println("ERROR: The matrices of this size can not be multiplied");
        }
        return matrixResult;
    }

    public Matrix resize(int rows, int columns) {
        Matrix matrixResult = new Matrix(rows, columns);
        int minRows = Math.min(this.rows, rows);
        int minColumns = Math.min(this.columns, columns);
        for (int i = 0; i < minRows; i++) {
            for (int j = 0; j < minColumns; j++) {
                matrixResult.values[i][j] = values[i][j];
            }
        }
        this.rows = rows;
        this.columns = columns;
        values = matrixResult.values;
        return matrixResult;
    }

    public void printSize() {
        System.out.println("rows: " + getRows());
        System.out.println("columns: " + getColumns());
    }

    public void printValue() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.format("%5d", values[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
