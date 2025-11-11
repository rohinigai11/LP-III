#include <iostream>
#include <vector>
using namespace std;

// Function to print the final N-Queens matrix
void printBoard(vector<vector<int>> &board) {
    int n = board.size();
    cout << "\nN-Queens Matrix:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cout << board[i][j] << " ";
        cout << endl;
    }
}

// Function to check if placing queen at (row, col) is safe
bool isSafe(vector<vector<int>> &board, int row, int col) {
    int n = board.size();

    // Check vertical column
    for (int i = 0; i < row; i++)
        if (board[i][col] == 1) return false;

    // Check upper left diagonal
    for (int i = row-1, j = col-1; i>=0 && j>=0; i--, j--)
        if (board[i][j] == 1) return false;

    // Check upper right diagonal
    for (int i = row-1, j = col+1; i>=0 && j<n; i--, j++)
        if (board[i][j] == 1) return false;

    return true;
}

// Recursive Backtracking function to place queens
bool solveNQueens(vector<vector<int>> &board, int row) {
    int n = board.size();
    if (row >= n) return true; // All queens placed

    // If first queen is already placed in this row, skip to next row
    for (int col = 0; col < n; col++) {
        if (board[row][col] == 1) {
            if (solveNQueens(board, row+1)) return true;
            else return false; // If first queen placement leads to no solution
        }
    }

    // Try placing queen in each column
    for (int col = 0; col < n; col++) {
        if (isSafe(board, row, col)) {
            board[row][col] = 1;
            if (solveNQueens(board, row+1)) return true;
            board[row][col] = 0; // Backtrack
        }
    }

    return false; // No valid position found
}

int main() {
    int n, firstRow, firstCol;
    cout << "Enter size of the board (N): ";
    cin >> n;

    vector<vector<int>> board(n, vector<int>(n, 0));

    cout << "Enter row and column for first queen (0-indexed): ";
    cin >> firstRow >> firstCol;

    if (firstRow < 0 || firstRow >= n || firstCol < 0 || firstCol >= n) {
        cout << "Invalid position!\n";
        return 0;
    }

    board[firstRow][firstCol] = 1; // Place first queen

    if (solveNQueens(board, 0)) {
        printBoard(board);
    } else {
        cout << "No solution exists with the first queen at given position.\n";
    }

    return 0;
}
