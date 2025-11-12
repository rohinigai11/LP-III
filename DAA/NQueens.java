import java.util.*;

public class NQueens {

    // Function to print the final N-Queens matrix
    static void printBoard(int[][] board) {
        int n = board.length;
        System.out.println("\nN-Queens Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    // Function to check if placing queen at (row, col) is safe
    static boolean isSafe(int[][] board, int row, int col) {
        int n = board.length;

        // Check vertical column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    // Recursive Backtracking function to place queens
    static boolean solveNQueens(int[][] board, int row) {
        int n = board.length;
        if (row >= n) return true; // All queens placed

        // If first queen is already placed in this row, skip to next row
        for (int col = 0; col < n; col++) {
            if (board[row][col] == 1) {
                if (solveNQueens(board, row + 1)) return true;
                else return false; // If first queen placement leads to no solution
            }
        }

        // Try placing queen in each column
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (solveNQueens(board, row + 1)) return true;
                board[row][col] = 0; // Backtrack
            }
        }

        return false; // No valid position found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the board (N): ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        System.out.print("Enter row and column for first queen (0-indexed): ");
        int firstRow = sc.nextInt();
        int firstCol = sc.nextInt();

        if (firstRow < 0 || firstRow >= n || firstCol < 0 || firstCol >= n) {
            System.out.println("Invalid position!");
            return;
        }

        board[firstRow][firstCol] = 1; // Place first queen

        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists with the first queen at given position.");
        }

        sc.close();
    }
}
