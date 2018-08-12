package exercises.crackingthecodinginterview.arraysandstrings;

/**
 * Write an algorithm such that if an element in am MxN
 * matrix is 0, its entire row and column are set to 0
 */
public class ZeroMatrix {
    public static void zeroMatrix(int[][] matrix) {
        if(matrix.length > 0) {
            int length = matrix[0].length;
            int height = matrix.length;
            boolean[] rows = new boolean[height];
            boolean[] cols = new boolean[length];
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < length; j++) {
                    if(matrix[i][j] == 0) {
                        rows[i] = true;
                        cols[j] = true;
                    }
                }
            }
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < length; j++) {
                    if(rows[i] || cols[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
