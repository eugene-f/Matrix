import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        int[][] matrix = new int[10][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[10];
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = -i;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i]);
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }
}
