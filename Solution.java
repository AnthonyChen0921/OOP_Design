
// declare solution class
public class Solution{

    // given an array of ints, identify the highest sorted count both ascending and descending
    public static int[] highestSortedCount(int[] arr){
        // declare variables
        int[] result = new int[2];
        int ascCount = 1;
        int descCount = 1;
        int ascMax = 1;
        int descMax = 1;
        // iterate through array
        for(int i = 0; i < arr.length - 1; i++){
            // check if next element is greater than current element
            if(arr[i] < arr[i + 1]){
                // increment ascending count
                ascCount++;
                // check if ascending count is greater than ascending max
                if(ascCount > ascMax){
                    // set ascending max to ascending count
                    ascMax = ascCount;
                }
            } else {
                // reset ascending count
                ascCount = 1;
            }
            // check if next element is less than current element
            if(arr[i] > arr[i + 1]){
                // increment descending count
                descCount++;
                // check if descending count is greater than descending max
                if(descCount > descMax){
                    // set descending max to descending count
                    descMax = descCount;
                }
            } else {
                // reset descending count
                descCount = 1;
            }
        }
        // set result array
        result[0] = ascMax;
        result[1] = descMax;
        // return result array
        return result;
    }
    
    // return all characters that are in the first string but not the second
    public static String missingChars(String str1, String str2){
        // declare variables
        String result = "";
        // iterate through first string
        for(int i = 0; i < str1.length(); i++){
            // check if character is not in second string
            if(str2.indexOf(str1.charAt(i)) == -1){
                // add character to result string
                result += str1.charAt(i);
            }
        }
        // return result string
        return result;
    }

    // each character in second string cancel out the character in the first string
    // for example, "aab" and "a" would return "ab", "aab" and "aa" would return "b"
    public static String cancelOut(String str1, String str2){
        // declare variables
        String result = "";
        // iterate through first string
        for(int i = 0; i < str1.length(); i++){
            // check if character is not in second string
            if(str2.indexOf(str1.charAt(i)) == -1){
                // add character to result string
                result += str1.charAt(i);
            }
        }
        // return result string
        return result;
    }

    // Given the position of queen and position of opponent piece, determine if the queen may attack the opponent piece
    // Print a string "Yes" if the queen may attack the opponent piece, otherwise print "No"
    public static void queenAttack(int queenRow, int queenCol, int opponentRow, int opponentCol){
        // check if queen row is equal to opponent row
        if(queenRow == opponentRow){
            // print yes
            System.out.println("Yes");
        // check if queen column is equal to opponent column
        } else if(queenCol == opponentCol){
            // print yes
            System.out.println("Yes");
        // check if queen row - opponent row is equal to queen column - opponent column
        } else if(queenRow - opponentRow == queenCol - opponentCol){
            // print yes
            System.out.println("Yes");
        // check if queen row - opponent row is equal to opponent column - queen column
        } else if(queenRow - opponentRow == opponentCol - queenCol){
            // print yes
            System.out.println("Yes");
        } else {
            // print no
            System.out.println("No");
        }
    }

    // Given a list of N integers. Find the largest sum of a continuous sequence of integers
    // For example, given the list [2, -8, 3, -2, 4, -10], the largest sum is 5
    public static int largestSum(int[] arr){
        // declare variables
        int max = 0;
        int sum = 0;
        // iterate through array
        for(int i = 0; i < arr.length; i++){
            // add current element to sum
            sum += arr[i];
            // check if sum is greater than max
            if(sum > max){
                // set max to sum
                max = sum;
            }
            // check if sum is less than 0
            if(sum < 0){
                // reset sum
                sum = 0;
            }
        }
        // return max
        return max;
    }

    // Given an integer x, find the number of integers less than or equal to X whose digits adds up to Y
    // For example, given X = 20 and Y = 5, the answer is 2 (5, 14)
    // use time complexity of O(logX)
    public static int digitSum(int x, int y){
        // declare variables
        int result = 0;
        // iterate through numbers less than or equal to x
        for(int i = 1; i <= x; i++){
            // check if sum of digits is equal to y
            if(sumDigits(i) == y){
                // increment result
                result++;
            }
        }
        // return result
        return result;
    }
    public static int sumDigits(int x){
        // declare variables
        int sum = 0;
        // iterate through digits of x
        while(x > 0){
            // add digit to sum
            sum += x % 10;
            // divide x by 10
            x /= 10;
        }
        // return sum
        return sum;
    }
    
    
    // Given a log entry s and target word t, the target word can be obtained by selecing some subset of characters from s that can be rearranged to from t and remove them from s;
    // Determine the max number of times the target word can be obtained from s
    // For example, given s = "mononom" and t = "mon", the answer is 2
    // Given s = "ababab" and t = "ab", the answer is 3
    public static int maxTargetWord(String s, String t){
        // declare variables
        int count = 0;
        // iterate through string
        for(int i = 0; i < s.length(); i++){
            // check if character is in target word
            if(t.indexOf(s.charAt(i)) != -1){
                // remove character from target word
                t = t.replaceFirst(String.valueOf(s.charAt(i)), "");
                // check if target word is empty
                if(t.isEmpty()){
                    // increment count
                    count++;
                    // reset target word
                    t = s;
                }
            }
        }
        // return count
        return count;
    }

    
    // given input string s , and a pattern p, imlement regular expression matching with support for '.' and '*'
    // '.' matches any single character
    // '*' matches zero or more of the preceding element
    // for example, given s = "aa" and p = "a", return false
    // given s = "aa" and p = "a*", return true
    // given s = "ab" and p = ".*", return true
    // given s = "aab" and p = "c*a*b", return true
    // using dynamic programming
    public static boolean isMatch(String s, String p){
        // declare variables
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // set first element to true
        dp[0][0] = true;
        // iterate through pattern
        for(int i = 0; i < p.length(); i++){
            // check if current character is asterisk
            if(p.charAt(i) == '*'){
                // set current element to previous element
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        // iterate through string
        for(int i = 0; i < s.length(); i++){
            // iterate through pattern
            for(int j = 0; j < p.length(); j++){
                // check if current character is asterisk
                if(p.charAt(j) == '*'){
                    // check if previous character is equal to current character or previous character is period
                    if(p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.'){
                        // set current element to previous element or two elements before previous element
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                    } else {
                        // set current element to two elements before previous element
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                // check if current character is period or current character is equal to current character
                } else if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){
                    // set current element to previous element
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        // return last element
        return dp[s.length()][p.length()];
        
    }
    
  
    
    public static void main(String[] args) {
        
    }
}