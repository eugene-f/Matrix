package com.epam.matrix;

public class Runner {

    public static void main(String[] args) {

        Matrix matrixA = new Matrix(3, 3);
        matrixA.init();
        matrixA.print();

        Matrix matrixC = matrixA.multiplicate(matrixA);
        matrixC.print();

    }
}
