/**
Given a palindromic string of lowercase English letters palindrome, replace 
exactly one character with any lowercase English letter so that the resulting 
string is not a palindrome and that it is the lexicographically smallest one possible.
 

 Return the resulting string. If there is no way to replace a character to make 
it not a palindrome, return an empty string. 

 A string a is lexicographically smaller than a string b (of the same length) 
if in the first position where a and b differ, a has a character strictly smaller 
than the corresponding character in b. For example, "abcc" is lexicographically 
smaller than "abcd" because the first position they differ is at the fourth 
character, and 'c' is smaller than 'd'. 

 
 Example 1: 

 
Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as 
"zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.
 

 Example 2: 

 
Input: palindrome = "a"
Output: ""
Explanation: There is no way to replace a single character to make "a" not a 
palindrome, so return an empty string.
 

 
 Constraints: 

 
 1 <= palindrome.length <= 1000 
 palindrome consists of only lowercase English letters. 
 

 Related Topics String Greedy 👍 2312 👎 742

*/

package leetcode.editor.en;

public class P1328＿BreakAPalindrome{
    public static void main(String[] args) {
        Solution solution = new P1328＿BreakAPalindrome().new Solution();
        System.out.println(solution.breakPalindrome("a"));
        System.out.println(solution.breakPalindrome("abccba"));
        System.out.println(solution.breakPalindrome("aaaaaa"));
        System.out.println(solution.breakPalindrome("aba"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if(length <= 1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean isNonePalindrome = false;
        for(int i=0; i < length; i++){
            if(palindrome.charAt(i) != 'a'){
                return palindrome.substring(0, i) + "a" + palindrome.substring(i+1, length);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}