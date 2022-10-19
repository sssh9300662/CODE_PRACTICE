//A string s is nice if, for every letter of the alphabet that s contains,
// it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A'
//and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
//
// Given a string s, return the longest substring of s that is nice. If there are multiple,
// return the substring of the earliest occurrence. If there are none,return an empty string.
//
// 
// Example 1:
//Input: s = "YazaAay"
//Output: "aAa"
//Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
//"aAa" is the longest nice substring.
//
//
// Example 2:
//Input: s = "Bb"
//Output: "Bb"
//Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole 
//string is a substring.
// 
//
// Example 3:
//Input: s = "c"
//Output: ""
//Explanation: There are no nice substrings.
//
//
// Constraints:
// 1 <= s.length <= 100 
// s consists of uppercase and lowercase English letters. 
// 
// Related Topics Hash Table String Divide and Conquer Bit Manipulation Sliding 
//Window 
// 👍 816 👎 592

package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

//Java：Longest Nice Substring
public class P1763LongestNiceSubstring{
    public static void main(String[] args) {
        Solution solution = new P1763LongestNiceSubstring().new Solution();
        System.out.println(solution.longestNiceSubstring("YazaAay"));
        System.out.println(solution.longestNiceSubstring("Bb"));
        System.out.println(solution.longestNiceSubstring("c"));
        System.out.println(solution.longestNiceSubstring("abABB"));
        System.out.println(solution.longestNiceSubstring("dDzeE"));
        System.out.println(solution.longestNiceSubstring("ijIJwuUnW"));
        System.out.println(solution.longestNiceSubstring("qlERNCNVvWLOrrkAaDcXnlaDQxNEneRXQMKnrNN"));
        System.out.println(solution.longestNiceSubstring("YyKyIoyEeUhJnvevOyvBkNjmmyhoBBByUhhumVBnbckyjBBnnBBEHBeBBhbmhvhmyHRUnHmnheBobUnMBYvBtyCnyenmU"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestNiceSubstring(String s) {
        int end = s.length();
        int start = 0;
        String result = "";
        while(end -start > 1){
            for(int i = start; i < end-1; end--){
                String subStr = s.substring(start, end);
                if(isNice(subStr) && subStr.length() > result.length()){
                    result = subStr;
                }
                if (end == start+2) {// next round
                    end = s.length();
                    start = start +1;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isNice(String s){
        Set<Character> chs = new HashSet<>();
        for(int i =0; i < s.length(); i++){
            chs.add(s.charAt(i));
        }
        for(Character ch: chs){
            if(Character.isUpperCase(ch) && chs.contains(Character.toLowerCase(ch))){
                continue;
            }
            if(Character.isLowerCase(ch) && chs.contains(Character.toUpperCase(ch))){
                continue;
            }
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}