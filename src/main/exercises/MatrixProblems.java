package exercises;

public class MatrixProblems {
    /**
     * Write an algorithm such that if an element in an MxN
     * matrix is 0, its entire row and column are set to 0
     * @param m
     */
    public void zeroOutRowsColumns(int[][] m) {
        int row = 0;
        int col  = 0;
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                if(m[i][j] == 0) {
                    int shift = 1 << i;
                    row = row | shift;
                    shift = 1 << j;
                    col = col | shift;
                }
            }
        }
        for(int i = 0; i < m.length; i++) {
            int last = row % 2;
            row = row >> 1;
            if(last == 1) clearRow(m, i);
        }
        for(int j = 0; j < m[0].length; j++) {
            int last =  col % 2;
            col =  col >> 1;
            if(last == 1) clearCol(m, j);
        }
    }

    private void clearRow(int[][]m, int row) {
        for(int j = 0; j < m[row].length; j++) {
            m[row][j] = 0;
        }
    }

    private void clearCol(int[][]m, int col) {
        for(int i = 0; i < m.length; i++) {
            m[i][col] = 0;
        }
    }
}
