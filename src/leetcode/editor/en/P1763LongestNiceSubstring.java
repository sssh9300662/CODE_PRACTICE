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
        Solution2 solution = new P1763LongestNiceSubstring().new Solution2();
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
    /**
     * Brute force
     */
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
    /**
     * Divide & Conquer
     */
    class Solution2 {
        public String longestNiceSubstring(String s) {
            if(s.length() <=1){// at least need two characters
                return "";
            }
            int end = s.length()-1;
            int start = 0;
            // position that the character make a string is not nice
            // 將一個問題分解為一系列子問題 (sub problem)
            int invalidChIndex = isNice(s, start, end);
            if(invalidChIndex == -1){// not invalid character means it's nice
                return s;
            }
            // Based on invalid character, divide a string
            // 使用相同邏輯解決各子問題，如果問題夠小，可以直接求解。
            String leftStr = longestNiceSubstring(s.substring(start, invalidChIndex));
            String rightStr = longestNiceSubstring(s.substring(invalidChIndex+1, end+1));
            // Conquer (find valid one form sub result) 將子問題的結果合併
            return (leftStr.length() > rightStr.length())? leftStr: rightStr;
        }

        /**
         * For checking whether the string is nice or not, we can use a set,
         * if no uppercase or lowercase characters of any alphabets are present in the set,
         * it means string s is not a nice string.
         * @param s
         * @return
         */
        private int isNice(String s, int start, int end){
            Set<Character> chs = getCharacterSet(s, start, end);
            for(int i =start; i <= end; i++){
                Character ch = s.charAt(i);
                if(Character.isUpperCase(ch) && chs.contains(Character.toLowerCase(ch))){
                    continue;
                }
                if(Character.isLowerCase(ch) && chs.contains(Character.toUpperCase(ch))){
                    continue;
                }
                return i;
            }
            return -1;
        }

        private Set<Character> getCharacterSet(String s, int start, int end){
            Set<Character> chs = new HashSet<>();
            for(int i =start; i <= end; i++){
                chs.add(s.charAt(i));
            }
            return chs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}