public class Solution1 {
    // determine if a 9x9 sudoku board is valid. only the filled cells need to be validated according to the following rules:
    // each row must contain the digits 1-9 without repetition.
    // each column must contain the digits 1-9 without repetition.
    // each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    public boolean isValidSudoku(char[][] board) {
        // check each row
        for (int i = 0; i < 9; i++) {
            boolean[] flag = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // check if the number has been used
                    if (flag[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    flag[(int) (board[i][j] - '1')] = true;
                }
            }
        }
        // check each column
        for (int j = 0; j < 9; j++) {
            boolean[] flag = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (flag[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    flag[(int) (board[i][j] - '1')] = true;
                }
            }
        }
        // check each 3 x 3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] flag = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (flag[(int) (board[i][j] - '1')]) {
                            return false;
                        }
                        flag[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }
        return true;
    }
}
