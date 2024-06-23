// Given a string text and an array of strings words, return an array of all index pairs [i, j]
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
import java.util.*;
import java.util.stream.Collectors;

//Java：Index Pairs of a String
public class P1065IndexPairsOfAString{
    public static void main(String[] args) {
        Solution2 solution = new P1065IndexPairsOfAString().new Solution2();
        int[][]result = solution.indexPairs("ababa", new String[]{"aba","ab"});
        for(int[] value : result){
            System.out.println(value[0] + "," + value[1]);

        }
        result = solution.indexPairs("thestoryofleetcodeandme",
             new String[]{"story","fleet","leetcode"});
        for(int[] value : result){
            System.out.println(value[0] + "," + value[1]);

        }
    }

    class Solution2 {
        public int[][] indexPairs(String text, String[] words) {
            Set<String> wordSet = new HashSet<>();
            for(String word: words){
                wordSet.add(word);
            }
            ArrayList<int[]> result = new ArrayList<>();
            int start = 0;
            findPair(start, text, wordSet, result);
            return result.toArray(new int[][]{});
        }

        private void findPair(int start, String text, Set<String> wordSet, ArrayList<int[]> result) {
            StringBuilder sb = new StringBuilder();
            for(int i =start; i < text.length(); i++){
                sb.append(text.charAt(i));
                if(wordSet.contains(sb.toString())){
                    int[] pair= new int[]{start, i};
                    result.add(pair);
                }
                if(i == text.length()-1){
                    findPair(start+1, text, wordSet, result);
                }
            }
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] indexPairs(String text, String[] words) {
            ArrayList<int[]> result = new ArrayList<>();
            List<String> wordsList = Arrays.asList(words);
            findPair(0, text, wordsList, result);
            return result.toArray(new int[][]{});
        }

        private void findPair(int start, String text, List<String> words, ArrayList<int[]> result){
            int match = 0;
            StringBuilder sb = new StringBuilder();

            for(int i=start; i < text.length(); i++){
                String s = String.valueOf(text.charAt(i));
                sb.append(s);
                if(words.contains(sb.toString())){
                    result.add(new int[]{start, start + sb.toString().length()-1});
                    match++;
                }
                if(match == words.size()){// all find
                    break;
                }
            }
            if(start < text.length()){
                findPair(start+1, text, words, result);
            }
        }

        // The problem-solver should have a look at Trie data structure. It is the perfect match
        // for the question. https://docs.spiralgo.com/lc-1065.-index-pairs-of-a-string
        class Trie{
            Trie[] children;
            boolean end;   /*indicate whether there is a word*/
            public Trie(){
                end=false;
                children=new Trie[26];
            }
        }

        public int[][] indexPairsByTrie(String text, String[] words) {
            Trie trie=new Trie(); // 字典樹
            for(String s:words){
                Trie cur=trie;
                for(char c:s.toCharArray()){
                    if(cur.children[c-'a']==null){// 資料不存在
                        cur.children[c-'a']=new Trie();
                    }
                    cur=cur.children[c-'a'];
                }
                cur.end=true; // complete a word in trie
            }
            List<int[]> list=new ArrayList<>();
            for(int i=0; i < text.length(); i++){
                Trie cur=trie;
                Character ch = text.charAt(i);
                int curIndex = i;
                while(cur.children[ch - 'a'] != null){ // a window expend one character each time
                    cur=cur.children[ch-'a'];
                    if(cur.end){//search find
                        list.add(new int[]{i, curIndex});
                    }
                    curIndex++;
                    if(curIndex == text.length()){ //reach last, should go next round
                        break;
                    }else{
                        ch = text.charAt(curIndex); // check next char
                    }
                }
            }
            return list.toArray(new int[][]{});
        }
    }
}