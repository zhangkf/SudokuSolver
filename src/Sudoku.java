public class Sudoku {

    private int[][] board;

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
        return nakedSinglesInRows() || nakedSinglesInCols() || nakedSinglesInBoxes();
    }

    private boolean nakedSinglesInBoxes() {
        return nakedSingleInBox(0, 0)
                || nakedSingleInBox(0, 3)
                || nakedSingleInBox(0, 6)
                || nakedSingleInBox(3, 0)
                || nakedSingleInBox(3, 3)
                || nakedSingleInBox(3, 6)
                || nakedSingleInBox(6, 0)
                || nakedSingleInBox(6, 3)
                || nakedSingleInBox(6, 6);

    }

    private boolean nakedSingleInBox(int i1, int j1) {
        int countOfEmptyCell = 0;
        int emptyCellIndexI = 0;
        int emptyCellIndexJ = 0;
        int[] placeholder = new int[10];
        for (int i = i1; i < i1+3; i++) {
            for (int j = j1; j < j1+3; j++) {
                placeholder[board[i][j]]=board[i][j];
                if (board[i][j] == 0) {
                    countOfEmptyCell++;
                    emptyCellIndexI = i;
                    emptyCellIndexJ = j;
                }
            }
        }

        if (countOfEmptyCell == 1) {
            for (int j = 1; j < placeholder.length; j++) {
                if (placeholder[j] == 0) {
                    board[emptyCellIndexI][emptyCellIndexJ] = j;
                    return true;
                }
            }
        }
        return false;
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
                        return true;
                    }
                }
            }

        }

        return false;

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

            if(countOfEmptyCell ==  1) {
                int[] placeholder = new int[10];
                for (int j = 0; j < 9; j++) {
                    placeholder[board[j][i]] = board[j][i];
                }
                for (int j = 1; j < placeholder.length; j++) {
                    if (placeholder[j] == 0) {
                        board[emptyCellIndex][i] = j;
                        return true;
                    }
                }
            }
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
