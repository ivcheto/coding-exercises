package exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixProblemsTest {

    MatrixProblems mp;

    @BeforeEach
    public void setup() {
        mp = new MatrixProblems();
    }

    @Test
    public void rows_and_cols_are_cleared_out() {
        int[][] m = new int[4][3];
        m[0] = new int[]{1, 1, 0};
        m[1] = new int[]{1, 1, 1};
        m[2] = new int[]{1, 0, 1};
        m[3] = new int[]{1, 0, 1};

        mp.zeroOutRowsColumns(m);

        assertTrue(rowIsZero(m,0));
        assertTrue(rowIsZero(m,2));
        assertTrue(rowIsZero(m,3));
        assertTrue(colIsZero(m, 1));
        assertTrue(colIsZero(m, 2));
    }

    private boolean rowIsZero(int[][]m, int i) {
        for(int j = 0; j < m[i].length; j++) {
            if(m[i][j] != 0) return false;
        }
        return true;
    }

    private boolean colIsZero(int[][] m, int j) {
        for(int i = 0; i < m.length; i ++) {
            if(m[i][j] != 0) return false;
        }
        return true;
    }

    private void printMatrix(int[][] m) {
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
