import java.util.*;

public class Solution3 {
    // Given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    // Merge all the linked-lists into one sorted linked-list and return it.
    // Example 1:
    // Input: lists = [[1,4,5],[1,3,4],[2,6]]
    // Output: [1,1,2,3,4,4,5,6]
    // Example 2:
    // Input: lists = []
    // Output: []
    // Example 3:
    // Input: lists = [[]]
    // Output: []
    // use priority queue
    public static ListNode mergeKLists(ListNode[] lists){
        // declare variables
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        // iterate through lists
        for(ListNode node : lists){
            if(node != null){
                queue.add(node);
            }
        }
        // iterate through queue
        while(!queue.isEmpty()){
            // declare variables
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;
            if(node.next != null){
                queue.add(node.next);
            }
        }
        // return dummy.next
        return dummy.next;
    }

    // given a linked list, swap every two adjacent nodes and return its head
    // Example 1:
    // Input: head = [1,2,3,4]
    // Output: [2,1,4,3]
    // Example 2:
    // Input: head = []
    // Output: []
    // Example 3:
    // Input: head = [1]
    // Output: [1]
    // use recursion
    public static ListNode swapPairs(ListNode head){
        // base case
        if(head == null || head.next == null){
            return head;
        }
        // declare variables
        ListNode first = head;
        ListNode second = head.next;
        // swap
        first.next = swapPairs(second.next);
        second.next = first;
        // return second
        return second;
    }
    public static int expandAroundCenter(String inputStr, int left, int right){
        // declare variables
        int L = left;
        int R = right;
        // iterate through inputStr
        while(L >= 0 && R < inputStr.length() && inputStr.charAt(L) == inputStr.charAt(R)){
            L--;
            R++;
        }
        // return R - L - 1
        return R - L - 1;
    }
    // given inputStr, return a sub-string which is the longest palindrome
    // Example 1:
    // Input: inputStr = "YABCCBAZ"
    // Output: "ABCCBA"
    // Example 2:
    // Input: inputStr = "ABC"
    // Output: "None"
    public static String longestPalindrome(String inputStr){
        // declare variables
        int start = 0;
        int end = 0;
        // iterate through inputStr
        for(int i = 0; i < inputStr.length(); i++){
            // declare variables
            int len1 = expandAroundCenter(inputStr, i, i);
            int len2 = expandAroundCenter(inputStr, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // return inputStr.substring(start, end + 1)
        return inputStr.substring(start, end + 1);
    }

    // given 2 integers, inputNum1 and inputNum2, return the count of numbers whose digits add up to Y for the given number X
    // Input: 20, 5 
    // Output: 2
    // Explanation: x = 20, y = 5, there are only 2 integers < 20, 5 and 14 whose digits add up to 5
    // Input: 100, 10
    // Output: 19
    // Explanation: x = 100, y = 10, there are 19 integers < 100, 9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 10, 11, 12, 13, 14, 15, 16, 17, 19 whose digits add up to 10
    public static int count(int inputNum1, int inputNum2){
        // declare variables
        int count = 0;
        // iterate through inputNum1
        for(int i = 0; i < inputNum1; i++){
            // declare variables
            int sum = 0;
            int num = i;
            // iterate through num
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }
            // if sum == inputNum2
            if(sum == inputNum2){
                count++;
            }
        }
        // return count
        return count;
    }
    
    public static void main(String[] args) {
        // test longestPalindrome
        System.out.println(longestPalindrome("YABCCBAZ"));
    }



}
