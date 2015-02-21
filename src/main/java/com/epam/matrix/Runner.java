package com.epam.matrix;

public class Runner {

    public static void main(String[] args) {

        Matrix matrixA = new Matrix(3, 4);
        matrixA.initRandom();
        System.out.println("Matrix A");
        matrixA.print();

        Matrix matrixB = new Matrix(4, 5);
        matrixB.initRandom();
        System.out.println("Matrix B");
        matrixB.print();

        Matrix matrixC = Matrix.multiply(matrixA, matrixB);
        System.out.println("Matrix C");
        matrixC.print();

    }
}
