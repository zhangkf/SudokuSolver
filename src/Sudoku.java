import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private int[][] board;
    private static final List<Integer> SUDOKU_NUMBERS = new ArrayList<Integer>(){{
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
    }};


    public Sudoku(int[][] board) {
        this.board = board;
    }

    public Sudoku() {
        this.board = new int[9][9];
    }

    public void solve() {
        while (!isSolved() && (nakedSingles() || hiddenSingles()));

    }

    private boolean hiddenSingles() {
        return true;
    }

    private boolean nakedSingles() {
        nakedSinglesInRows();
        nakedSinglesInCols();

        return true;
    }

    private boolean nakedSinglesInRows(){
        for (int i = 0; i < 9; i++) {
            int[] cols = board[i];

            int countOfEmptyCell = 0;
            int emptyCellIndex = 0;

            for (int j = 0; j < cols.length; j++) {
                if(cols[j] == 0){
                    countOfEmptyCell++;
                    emptyCellIndex = j;
                }
            }

            if(countOfEmptyCell ==  1) {
                int[] placeholder = new int[10];
                for (int j = 0; j < cols.length; j++) {
                    placeholder[cols[j]] = cols[j];
                }
                for (int j = 1; j < placeholder.length; j++) {
                    if (placeholder[j] == 0) {
                        cols[emptyCellIndex] = j;
                    }
                }
            }

        }

        return true;

    }

    private boolean nakedSinglesInCols() {
        for (int i = 0; i < 9; i++) {
            int countOfEmptyCell = 0;
            int emptyCellIndex = 0;

            for (int j = 0; j < 9; j++) {
                if(board[j][i] == 0){
                    countOfEmptyCell++;
                    emptyCellIndex = j;
                }
            }

            if(countOfEmptyCell ==  0 ||  countOfEmptyCell > 1) return false;
            int[] placeholder = new int[10];
            for (int j = 0; j < 9; j++) {
                placeholder[board[j][i]] = board[j][i];
            }
            for (int j = 1; j < placeholder.length; j++) {
                if(placeholder[j] == 0){
                    board[emptyCellIndex][i] = j;
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isSolved() {
        for (int i = 0; i < board.length; i++) {
            int[] cols = board[i];
            for (int j = 0; j < cols.length; j++) {
                int cell = cols[j];
                if(cell == 0 ) return false;
            }
        }
        return true;
    }
}
