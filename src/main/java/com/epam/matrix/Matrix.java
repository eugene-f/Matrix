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
            for (int j = 0; j < columns; j++) {
                v[i][j] = values[i][j];
            }
        }
        this.values = v;
    }

    public Matrix(int rows, int columns, int[][] values) {
        if (values.length == rows && values[0].length == columns) {
            create(rows, columns);
            this.values = values;
        } else {
            System.out.println("ERROR: Dimension of the matrix does not coincide with the announced");
        }
    }

    private void create(int rows, int columns) {
        if (rows != 0 && columns !=0) {
            this.rows = rows;
            this.columns = columns;
            try {
                this.values = new int[rows][columns];
            } catch (NegativeArraySizeException e) {
                System.out.println("ERROR: The dimension of the matrix can not be a negative number");
            }
        } else {
            System.out.println("WARNING: Empty matrix can not be created");
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
        return values.length;
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
            System.out.println("ERROR: The matrices of this size can not be multiplied");
        }
        return matrixC;
    }

    public void initZero() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.values[i][j] = 0;
            }
        }
    }

    public void initRandom() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.values[i][j] = new Random().nextInt(16) + new Random().nextInt(16);
            }
        }
    }

    public Matrix resize(int rows, int columns) {
        Matrix r = new Matrix(rows, columns);
        int minRows = Math.min(this.rows, rows);
        int minColumns = Math.min(this.columns, columns);
        for (int i = 0; i < minRows; i++) {
            for (int j = 0; j < minColumns; j++) {
                r.values[i][j] = values[i][j];
            }
        }
        return r;
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

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
