
/**
 * Hello
 */

//import java.util.*;

public class CiscoPractice {

    // Given a list of integers, find the size of the list
    // and print the size of the list
    // Example: [1, 2, 3, 4, 5]
    // Input consists of space separated integers- inputArr
    // Output: 5
    public static void findSizeOfList(String inputArr) {
        String[] arr = inputArr.split(" ");
        System.out.println(arr.length);
    }

    // returns a chessboard pattern "B" for black and "W" for white
    // Input: number N
    // Generate a chessboard pattern of size N*N
    // Example: N = 3
    // Output: B W B
    //         W B W
    //         B W B
    /**
     * @breif: This function prints the chessboard pattern
     * @param N
     * 
     */
    public static void chessBoardPattern(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("B ");
                } else {
                    System.out.print("W ");
                }
            }
            System.out.println();
        }
    }


    // Given a grid N x M of letters, followed by a Knumber of words. The word may occur in a row or a column
    // Print space-separated strings "Yes" if the word is present in the grid
    // Print "No" if the word is not present in the grid
    // Example: N = 3, M = 3
    //          ABC
    //          DEF
    //          GHI
    //          2
    //          ABC
    //          DEF
    // Output: Yes
    //         Yes
    public static void findWordInGrid(int N, int M, String[] grid, int K, String[] words) {
        for (int i = 0; i < K; i++) {
            String word = words[i];
            boolean found = false;
            for (int j = 0; j < N; j++) {
                if (grid[j].contains(word)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int j = 0; j < M; j++) {
                    String col = "";
                    for (int k = 0; k < N; k++) {
                        col += grid[k].charAt(j);
                    }
                    if (col.contains(word)) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }



    public static int lengthOfLongestSubstring(String s){
        int max = 0;
        int[] cache = new int[256];
        for(int i=0, j=0; i< s.length(); i++){
            if(cache[s.charAt(i)] > 0){
                j = Math.max(j, cache[s.charAt(i)]);
            }
            cache[s.charAt(i)] = i+1;
            max = Math.max(max, i-j+1);
        }
        

        return max;
    }

    public static void main(String[] args) {
        chessBoardPattern(5);
        // hello world

    }
}
