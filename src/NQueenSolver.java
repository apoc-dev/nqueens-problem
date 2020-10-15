public class NQueenSolver {

    final int N = 8;

    private void nQstart(){

        int[][] board = new int[N][N];


        double start = System.currentTimeMillis();
        boolean result = solveNQ(board, 0);
        System.out.println(System.currentTimeMillis() - start + " ms");

        if (!result)
                System.out.println("no solution");
    }

    private void printBoard(int[][] board){

        System.out.println();

        for (int[] row : board){
            System.out.print("|");
            for (int col : row){
                if (col == 1) {
                    System.out.print(TerminalColours.ANSI_RED+ col + TerminalColours.ANSI_RESET);
                }else {
                    System.out.print(col);
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean solveNQ(int[][] board, int col){

        if (col >= N){
            printBoard(board);
            return true;
        }
        for (int row = 0; row < N; row++) {

            if (checkPlacement(board, row, col)){
                board[row][col] = 1;
                if (solveNQ(board, col + 1)){ //remove if to print all solutions
                    return true;
                }
            }
            board[row][col] = 0; // BACKTRACK
        }
        return false;
    }

    private boolean checkPlacement(int[][] board, int row, int col) {
        int i, j;

        // check row
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal */ //stolen
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal */ //stolen
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;


        return true;
    }

    public static void main(String[] args) {

        NQueenSolver nq = new NQueenSolver();
        nq.nQstart();

    }


}
