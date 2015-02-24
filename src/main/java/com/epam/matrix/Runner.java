package com.epam.matrix;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Matrix A - create (basic)");
        Matrix matrixA = new Matrix(5, 10);
        Printer.printSize(matrixA);
        Printer.printValue(matrixA);

        System.out.println("Matrix A - fill random");
        matrixA.fillRandom(10);
        Printer.printSize(matrixA);
        Printer.printValue(matrixA);

        System.out.println("Matrix A - resize (relatively)");
        matrixA.resize(matrixA.getMatrixRows() + 2, matrixA.getMatrixColumns() - 3);
        Printer.printSize(matrixA);
        Printer.printValue(matrixA);

        System.out.println("Matrix A - resize (absolutely)");
        matrixA.resize(7, 5);
        Printer.printSize(matrixA);
        Printer.printValue(matrixA);

        System.out.println("Matrix B - create (specified)");
        Matrix matrixB = new Matrix(new int[][]{
                {7, 4, 2},
                {8, 6, 9, 1, 5},
                {3, 4, 0, 2, 5, 9, 1},
                {5, 7, 2, 3, 0},
                {3, 3, 3}
        });
        Printer.printSize(matrixB);
        Printer.printValue(matrixB);

        System.out.println("Matrix C - multiply (static)");
        Matrix matrixC = Matrix.multiply(matrixA, matrixB);
        Printer.printSize(matrixC);
        Printer.printValue(matrixC);

        System.out.println("Matrix C - multiply (non-static)");
        matrixC = matrixA.multiply(matrixB);
        Printer.printSize(matrixC);
        Printer.printValue(matrixC);

        System.out.println("Matrix C - print size");
        Printer.printSize(matrixC);
        System.out.println();

        System.out.println("Matrix C - fill zero");
        matrixC.fillZero();
        Printer.printSize(matrixC);
        Printer.printValue(matrixC);

    }
}