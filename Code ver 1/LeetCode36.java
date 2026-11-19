import java.util.*;

class SudokuSolution{
    public boolean isValidSudoku(char[][] board) {
        boolean flag = true;
        Set<Character> set = new HashSet();
        for (int i = 0; i < 9 ; i += 3){
            // System.out.println(board[i]);
            for (int j = 0; j < 9 ; j += 3){
                // System.out.println(board[i][j]);
                for (int n = 0 + i; n < i+ 3; n++){
                    for (int m = 0 + j; m < j+3; m++){
                        if (set.contains(board[n][m]) && board[n][m] != '.' ){
                            return false;
                        }
                        else if (board[n][m] != '.') {
                            set.add(board[n][m]);
                        }
                        // System.out.println(board[n][m]);
                    }
                }
                // System.out.println("set 1 :" + set);
                set.clear();
                // System.out.println("set 2 :" + set);
            }
        }

        set.clear();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9 ; j++){
                if (set.contains(board[i][j]) && board[i][j] != '.' ){
                            return false;
                        }
                else if (board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
            // System.out.println("set 1 :" + set);
            set.clear();
            // System.out.println("set 2 :" + set);
        }

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9 ; j++){
                if (set.contains(board[j][i]) && board[j][i] != '.' ){
                            return false;
                        }
                else if (board[j][i] != '.') {
                    set.add(board[j][i]);
                }
            }
            // System.out.println("set 1 :" + set);
            set.clear();
            // System.out.println("set 2 :" + set);
        }


        // System.out.println(set);
        // System.out.println(Arrays.toString(board));
        // System.out.println(set);
        return true;
    }
}

public class LeetCode36 {

    public static void main(String[] args){
        SudokuSolution solution = new SudokuSolution();
        char[][] board = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
        };

        boolean result = solution.isValidSudoku(board);
        System.out.println(result);
    }
}
