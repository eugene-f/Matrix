package com.epam.matrix;

public class Printer {

    public static void printSize(Matrix matrix) {
        System.out.println("rows: " + matrix.getMatrixRows());
        System.out.println("columns: " + matrix.getMatrixColumns());
    }

    public static void printValue(Matrix matrix) {
        for (int i = 0; i < matrix.getMatrixRows(); i++) {
            for (int j = 0; j < matrix.getMatrixColumns(); j++) {
                System.out.format("%5d", matrix.getMatrixValue(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }

}
