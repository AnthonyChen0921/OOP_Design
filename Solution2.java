import java.util.*;

public class Solution2 {
    // given a nxn 2D matrix, rotate it 90 degrees clockwise return void with swapping 4 elements at a time
    public static void rotateMatrix(int[][] matrix){
        // declare variables
        int n = matrix.length;
        int temp;
        // iterate through matrix
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n - i - 1; j++){
                // swap 4 elements
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    

    // Given the price of Amazon stock for n months, 
    // find the maximum possible cumulative observable sum among all the observalbe groups of months. 
    // If there is no possible sum, return 0.
    // for example, given stockPrice = [1, 2, 7, 7, 4, 3, 6], number of consecutive months to cosider is k = 3.
    // the distinct months are [1,2,7], [7,4,3], [4,3,6].
    // the maximum is max(10, 14, 13) = 14
    // return 14
    public static int maxProfit(int[] stockPrice, int k){
        // declare variables
        int n = stockPrice.length;
        int max = 0;
        int sum = 0;
        // iterate through stockPrice
        for(int i = 0; i < n - k + 1; i++){
            // iterate through k months
            for(int j = i; j < i + k; j++){
                sum += stockPrice[j];
            }
            // update max
            if(sum > max){
                max = sum;
            }
            // reset sum
            sum = 0;
        }
        // return max
        return max;
    }

    // n-queens problem
    // Given an integer n, return all distinct solutions to the n-queens puzzle.
    // Each solution contains a distinct board configuration of the n-queens' placement,
    // where 'Q' and '.' both indicate a queen and an empty space respectively.
    // for example, given n = 4, return
    // [
    //  [".Q..",  // Solution 1
    //   "...Q",
    //   "Q...",
    //   "..Q."],
    //  ["..Q.",  // Solution 2
    //   "Q...",
    //   "...Q",
    //   ".Q.."]
    // ]
    public static List<List<String>> solveNQueens(int n){
        // declare variables
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();
        // initialize board
        for(int i = 0; i < n; i++){
            board.add("");
        }
        // call helper function
        helper(result, board, 0, n);
        // return result
        return result;
    }
    // helper function
    public static void helper(List<List<String>> result, List<String> board, int row, int n){
        // base case
        if(row == n){
            result.add(new ArrayList<>(board));
            return;
        }
        // iterate through columns
        for(int col = 0; col < n; col++){
            // check if valid
            if(isValid(board, row, col, n)){
                // update board
                board.set(row, getRow(col, n));
                // call helper function
                helper(result, board, row + 1, n);
                // reset board
                board.set(row, "");
            }
        }
    }
    // check if valid
    public static boolean isValid(List<String> board, int row, int col, int n){
        // check column
        for(int i = 0; i < row; i++){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }
        // check diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        // check diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        // return true
        return true;
    }
    // get row
    public static String getRow(int col, int n){
        // declare variables
        StringBuilder sb = new StringBuilder();
        // iterate through columns
        for(int i = 0; i < n; i++){
            if(i == col){
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        // return row
        return sb.toString();
    }


   // given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    // for example, given n = 3, a solution set is:
    // [
    //  "((()))",
    //  "(()())",
    //  "(())()",
    //  "()(())",
    //  "()()()"
    // ]
    // dynamic programming
    public static List<String> generateParenthesis(int n){
        // declare variables
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        // base case
        if(n == 0){
            return list;
        }
        // initialize list
        list.add("");
        result.add(list);
        // iterate through n
        for(int i = 1; i <= n; i++){
            // declare variables
            list = new ArrayList<>();
            // iterate through i
            for(int j = 0; j < i; j++){
                // iterate through result
                for(String first : result.get(j)){
                    for(String second : result.get(i - j - 1)){
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            // add list to result
            result.add(list);
        }
        // return result
        return result.get(n);
    }
    // use dfs
    public static List<String> generateParenthesis2(int n){
        // declare variables
        List<String> result = new ArrayList<>();
        // call helper function
        helper(result, "", 0, 0, n);
        // return result
        return result;
    }
    // helper function
    public static void helper(List<String> result, String str, int open, int close, int n){
        // base case
        if(str.length() == n * 2){
            result.add(str);
            return;
        }
        // check if open parentheses is less than n
        if(open < n){
            helper(result, str + "(", open + 1, close, n);
        }
        // check if close parentheses is less than open parentheses
        if(close < open){
            helper(result, str + ")", open, close + 1, n);
        }
    }
    

    public static void main(String[] args) {
        int[] stockPrice = {1,2,3,4};
        int k = 2;
        System.out.println(maxProfit(stockPrice, k));
        return;
    }
}
