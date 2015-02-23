package com.epam.matrix;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Matrix A - create (basic)");
        Matrix matrixA = new Matrix(10, 10);
        matrixA.printValue();

        System.out.println("Matrix A - init random");
        matrixA.fillRandom(10);
        matrixA.printValue();

        System.out.println("Matrix A - resize (absolutely)");
        matrixA.resize(3, 10);
        matrixA.printValue();

        System.out.println("Matrix A - resize (relatively)");
        matrixA.resize(matrixA.getRows() + 4, matrixA.getColumns() - 3);
        matrixA.printSize();
        matrixA.printValue();

        System.out.println("Matrix B - create (specified)");
        Matrix matrixB = new Matrix(new int[][]{
                {7, 4, 2},
                {8, 6, 9, 1, 5},
                {3, 4, 0, 2, 5, 9, 1},
                {5, 7, 2, 3, 0},
                {3, 3, 3}
        });
        matrixB.printValue();
        matrixB.printSize();

        System.out.println("Matrix C - multiply (static)");
        Matrix matrixC = Matrix.multiply(matrixA, matrixB);
        matrixC.printValue();

        System.out.println("Matrix C - multiply (non-static)");
        matrixC = matrixA.multiply(matrixB);
        matrixC.printValue();

        System.out.println("Matrix C - print size");
        matrixC.printSize();
        System.out.println();

        System.out.println("Matrix C - init zero");
        matrixC.fillZero();
        matrixC.printValue();

    }
}