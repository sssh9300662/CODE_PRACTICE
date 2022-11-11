//Given a string text and an array of strings words, return an array of all index pairs [i, j]
// so that the substring text[i...j] is in words.
//
// Return the pairs [i, j] in sorted order (i.e., sort them by their first coordinate,
// and in case of ties sort them by their second coordinate).
// 
// Example 1:
//Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
//Output: [[3,7],[9,13],[10,17]]
//
// Example 2:
//Input: text = "ababa", words = ["aba","ab"]
//Output: [[0,1],[0,2],[2,3],[2,4]]
//Explanation: Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].
// 
// Constraints:
// 1 <= text.length <= 100 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 50 
// text and words[i] consist of lowercase English letters. 
// All the strings of words are unique. 
// 
// Related Topics Array String Trie Sorting 
// 👍 254 👎 85

package leetcode.editor.en;
//Java：Index Pairs of a String
public class P1065IndexPairsOfAString{
    public static void main(String[] args) {
        Solution solution = new P1065IndexPairsOfAString().new Solution();
        System.out.println(solution.indexPairs("ababa", new String[]{"aba","ab"}));
        System.out.println(solution.indexPairs("thestoryofleetcodeandme",
                new String[]{"story","fleet","leetcode"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] indexPairs(String text, String[] words) {
            int[][] result = new int[][]{};
            for(String word : words){

            }
            return result;
        }
    }
}