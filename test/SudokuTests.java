import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SudokuTests {

    @Test
    public void testNakedSinglesInRow(){
        int[][] board = new int[][]{
                {1,6,7,3,0,4,8,2,9}
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));
    }

    @Test
    public void testNakedSinglesInRows(){
        int[][] board = new int[][]{
                {1,6,7,3,0,4,8,2,9},
                {2,5,7,4,8,9,0,1,6},
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));
    }


    @Test
    public void testNakedSinglesInColumn(){
        int[][] board = new int[][]{
                {1,0,0,0,0,0,0,0,0},
                {2,0,0,0,0,0,0,0,0},
                {3,0,0,0,0,0,0,0,0},
                {4,0,0,0,0,0,0,0,0},
                {5,0,0,0,0,0,0,0,0},
                {6,0,0,0,0,0,0,0,0},
                {7,0,0,0,0,0,0,0,0},
                {8,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));


    }

    @Test
    public void testNakedSinglesInBox(){
        int[][] board = new int[][]{
                {1,2,3,0,0,0,0,0,0},
                {4,5,6,0,0,0,0,0,0},
                {7,8,9,0,0,0,0,0,0}
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));

    }

    @Test
    public void testHiddenSingles(){
        int[][] board = new int[][]{
                {1,0,0,0,0,0,0,0,0},
                {2,0,0,0,0,0,0,0,0},
                {3,0,0,2,0,0,0,0,0},
                {4,0,0,0,6,0,0,0,0},
                {5,0,0,0,0,0,0,0,0},
                {6,0,0,0,8,0,0,0,0},
                {7,0,0,0,0,0,0,0,0},
                {8,0,0,0,0,2,0,0,0},
                {9,0,0,0,0,0,0,0,0}
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));
    }

}
