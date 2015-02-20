public class Runner {

    public static void main(String[] args) {

        int aI = 5;
        int aJ = 10;

        int bI = 3;
        int bJ = 7;

        int[][] matrixA = new int[aI][aJ];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                matrixA[i][j] = i;
                System.out.print(matrixA[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] matrixB = new int[bI][bJ];
        for (int i = 0; i < matrixB.length; i++) {
            for (int j = 0; j < matrixB.length; j++) {
                matrixB[i][j] = i;
                System.out.print(matrixB[i][j] + "   ");
            }
            System.out.println();
        }



        int[][] matrixC = new int[aI][bJ];
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC.length; j++) {
//                matrixC[i][j] = matrixA[][] * matrixB[][];
            }
        }

    }
}
