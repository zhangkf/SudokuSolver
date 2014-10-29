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
        return nakedSinglesInRows();
    }

    private boolean nakedSinglesInRows(){
        for (int i = 0; i < board.length; i++) {
            int[] cols = board[i];
            nakedSingleInOneRow(cols);

        }

        return true;

    }

    private boolean nakedSingleInOneRow(int[] cols) {
        //[2,3,5,6,8,0,9,7,1]

        int countOfEmptyCell = 0;
        int emptyCellIndex = 0;

        for (int i = 0; i < cols.length; i++) {
            if(cols[i] == 0){
                countOfEmptyCell++;
                emptyCellIndex = i;
            }
        }

        if(countOfEmptyCell ==  0 ||  countOfEmptyCell > 1) return false;
        int[] placeholder = new int[10];
        for (int i = 0; i < cols.length; i++) {
            placeholder[cols[i]] = cols[i];
        }
        for (int i = 1; i < placeholder.length; i++) {
            if(placeholder[i] == 0){
                cols[emptyCellIndex] = i;
                return true;
            }
        }
        return true;

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
