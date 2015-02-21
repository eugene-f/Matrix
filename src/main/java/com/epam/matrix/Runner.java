package com.epam.matrix;

public class Runner {

    public static void main(String[] args) {

//        Matrix matrixA = new Matrix(3, 4);
        Matrix matrixA = new Matrix(3, 4, new int[][]{
                {0, 7, 2, 7},
                {3, 3, 6, 7},
                {3, 4, 5, 4}
        });
        matrixA.initRandom();
        System.out.println("Matrix A");
        matrixA.print();

//        Matrix matrixB = new Matrix(4, 5);
        Matrix matrixB = new Matrix(4, 5, new int[][]{
                {5, 4, 5, 5, 6},
                {7, 4, 1, 3, 7},
                {5, 7, 5, 4, 7},
                {2, 3, 0, 3, 4}
        });
        matrixB.initRandom();
        System.out.println("Matrix B");
        matrixB.print();

        Matrix matrixC = Matrix.multiply(matrixA, matrixB);
        System.out.println("Matrix C");
        matrixC.print();

        matrixC.resize(matrixC.getRows() - 3, matrixC.getColumns() - 3).print();

        Matrix matrixT = new Matrix(new int[][]{
                {5, 4, 5, 6},
                {7, 4, 1, 3, 7},
                {5, 7, 5, 4, 7},
                {2, 3, 0, 3, 4}
        });
        System.out.println("Matrix T");
        matrixT.print();
        System.out.println("rows: " + matrixT.getRows());
        System.out.println("columns: " + matrixT.getColumns());

    }
}