package java;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> grid = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char rowVal = board[i][j];
                if (rowVal != '.' && !row.add(rowVal)) {
                    return false;
                }

                char colVal = board[j][i];

                if (colVal != '.' && col.contains(colVal)) {
                    return false;
                } else {
                    col.add(colVal);
                }

                int gridRow = 3 * (i / 3) + j / 3;
                int gridCol = 3 * (i % 3) + j % 3;
                char gridVal = board[gridRow][gridCol];
                if (gridVal != '.' && !grid.add(gridVal)) {
                    return false;
                }
            }
        }

        return true;
    }
}

// TC: O(m*n)
// SC: O(1) - as it is fixed len
