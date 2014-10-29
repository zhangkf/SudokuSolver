import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SudokuTests {

    @Test
    public void testNakedSinglesInRow(){
        int[][] board = new int[][]{
                {5,3,4,6,7,0,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9},
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));
    }

    @Test
    public void testNakedSinglesInRows(){
        int[][] board = new int[][]{
                {5,3,4,6,7,0,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,0,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9},
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));
    }


    @Test
    public void testNakedSinglesInColumn(){
        int[][] board = new int[][]{
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {0,5,9,7,6,0,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9},
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));


    }

    @Test
    public void testNakedSinglesInBox(){
        int[][] board = new int[][]{
                {5,3,0,6,7,8,0,1,2},
                {6,7,2,1,9,0,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,0,7,6,1,0,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9},
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        assertThat(sudoku.isSolved(), is(true));

    }


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
