import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N for n-queens: ");
        int n = sc.nextInt();
        long startTime = System.currentTimeMillis();
        int[][] board = new int[n][n];
        if (solveNQueens(board, 0, n)) {
        	long endTime = System.currentTimeMillis();
        	System.out.println("TIME TAKEN BY ABOVE FUNCTION TO CALCULATE N-QUEEN : "+(endTime-startTime));
            printBoard(board);
        } else {
            System.out.println("No solution found.");
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check if there is a Queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int row, int n) {
        if (row == n) {
            return true;  // All Queens have been placed successfully
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (solveNQueens(board, row + 1, n)) {
                    return true;
                }

                board[row][col] = 0;
            }
//            printBoard(board);
        }

        return false;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
