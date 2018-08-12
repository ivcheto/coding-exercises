package exercises.crackingthecodinginterview.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ZeroMatrixTest {

    @Test
    public void square_matrix_with_zeros() {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1, 0, 1, 1, 1};
        matrix[1] = new int[]{1, 1, 1, 0, 1};
        matrix[2] = new int[]{1, 1, 1, 1, 1};
        matrix[3] = new int[]{0, 1, 1, 1, 0};
        matrix[4] = new int[]{1, 1, 1, 1, 1};

        ZeroMatrix.zeroMatrix(matrix);

        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if((i == 2 && j == 2) || (i == 4 && j == 2)) {
                    assertEquals(1, matrix[i][j]);
                 } else {
                    assertEquals(0, matrix[i][j]);
                }
            }
        }
    }

    @Test
    public void square_matrix_without_zeros() {
        int[][] matrix = nonZeroMatrix(10, 10);

        ZeroMatrix.zeroMatrix(matrix);

        assertNoZeros(matrix);
    }

    @Test
    public void rectangular_matrix_with_zeros() {
        // TODO would be nice to generalize this
        int[][] matrix = new int[5][3];
        matrix[0] = new int[]{1, 0, 1};
        matrix[1] = new int[]{1, 1, 1};
        matrix[2] = new int[]{1, 1, 1};
        matrix[3] = new int[]{1, 0, 1};
        matrix[4] = new int[]{1, 1, 0};

        printMatrix(matrix);
        ZeroMatrix.zeroMatrix(matrix);
        printMatrix(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if((i == 1 && j == 0) || (i == 2 && j == 0)) {
                    assertEquals(1, matrix[i][j]);
                } else {
                    assertEquals(0, matrix[i][j]);
                }
            }
        }
    }

    @Test
    public void rectangular_matrix_without_zeros() {
        int[][] matrix = nonZeroMatrix(10, 5);

        ZeroMatrix.zeroMatrix(matrix);

        assertNoZeros(matrix);
    }

    private int[][] nonZeroMatrix(int height, int length) {
        int[][] matrix = new int[height][length];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < length; j++) {
                matrix[i][j] = 1;
            }
        }
        return  matrix;
    }

    private void assertNoZeros(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                assertNotEquals(0, matrix[i][j]);
            }
        }
    }

    private void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
