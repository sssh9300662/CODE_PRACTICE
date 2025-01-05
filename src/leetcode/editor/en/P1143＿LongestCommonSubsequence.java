/**
Given two strings text1 and text2, return the length of their longest common 
subsequence. If there is no common subsequence, return 0. 

 A subsequence of a string is a new string generated from the original string 
with some characters (can be none) deleted without changing the relative order of 
the remaining characters. 

 
 For example, "ace" is a subsequence of "abcde". 
 

 A common subsequence of two strings is a subsequence that is common to both 
strings. 

 
 Example 1: 

 
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
 

 Example 2: 

 
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
 

 Example 3: 

 
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

 
 Constraints: 

 
 1 <= text1.length, text2.length <= 1000 
 text1 and text2 consist of only lowercase English characters. 
 

 Related Topics String Dynamic Programming 👍 13926 👎 211

*/

package leetcode.editor.en;


import java.util.Arrays;

/**
 * - Longest subsequence
 * Please write the code to find the minimum and maximum value of the longest sequence from the given array of integer
 * ```
 * ```
 * Input  : [9, 0, 1, 3, 2, 5, 4, 10, 100]
 * Output : 0, 5 // Longest sequence is [0, 1, 2, 3, 4, 5]
 *
 * Input  : [0, -1, 15, -2, -3, 47, 99]
 * Output : -3, 0 // Longest sequence is [-3, -2, -1, 0]
 *
 * Input  : [2, 5, 3, 6, 1001, -1, -9]
 * Output : 2, 3 // There is no longest sequence in the input array (5,6 is also acceptable)
 *
 * ```
 * Constraints:
 * - Every element in the input array is between -10,000 to 10,000
 * ```
 */
public class P1143＿LongestCommonSubsequence{
    public static void main(String[] args) {
        int[] input  = new int[] {9, 0, 1, 3, 2, 5, 4, 10, 100};
        Solution solution = new P1143＿LongestCommonSubsequence().new Solution();
        // int[] result = solution.longestCommonSubsequence(input);
        // int[] result = solution.longestCommonSubsequence(new int[]{0, -1, 15, -2, -3, 47, 99});
        int[] result = solution.longestCommonSubsequence(new int[]{2, 5, 3, 6, 1001, -1, -9});
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] longestCommonSubsequence(int[] input) {
        if(input.length == 0){
            return null;
        }
        if(input.length == 1){
            return new int[]{0,0};
        }
        int start = 0;
        int[] result = new int[2];
        int max = 0;
        Arrays.sort(input); // Sort the array
        for(int i=1; i< input.length; i++){
            if(input[i] == input[i-1]){// Skip duplicates
                continue;
            }
            if(input[i] == input[i-1] +1){
                continue;
            }
            int length = i - start;
            //System.out.println("length=" + length);
            if(length > max && length >=2){
                //System.out.println("i=" + i);
                //System.out.println("start=" + start);
                result[0] = input[start];
                result[1] = input[i-1];
                max = length;
            }
            if(max >= (input.length- i)){// number of rest elements smaller than max
                //System.out.println(i);
                return result;
            }
            start = i;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}