package slidingwindow;

// Given a string s, find the length of the longest substring without repeating characters.
//
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static void main(String args[]) {
        LongestSubstringWithoutRepeating obj = new LongestSubstringWithoutRepeating();
        System.out.println(obj.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring2(" "));
        System.out.println(obj.lengthOfLongestSubstring2("au"));
        System.out.println(obj.lengthOfLongestSubstring2("dvdf"));
    }

    public LongestSubstringWithoutRepeating() {
        // TODO Auto-generated constructor stub
    }
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map= new HashMap<>();
        int max = 0, startIndex = 0;
        int length = s.length();
        if(length <= 1){
            return length;
        }
       for(int i=0; i<length; i++){
           char c = s.charAt(i);
           if(map.containsKey(c)){
               startIndex = Math.max(map.get(c)+1, // 往前移一個statIndex, 因為重複代表到end,所以上一個心同字元是開始
                       startIndex); //不能比目前start小, 因為重複的string可能已經出現在當前startIndex前面
           }
           map.put(c, i); // 新增 或 更新 每個字元最後位置
           max = Math.max(max, i-startIndex+1); // 目前位置 - 開始位置  (+1 是因位stat在前面被更新前移過)
       }
       return max;
    }
    
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map= new HashMap<>(); // current index of character
        int start=0, len=0;
        // abba
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start) { // check whether have to move current index (reset start)
                    start = map.get(c) + 1;
                }
            }
            len = Math.max(len, i-start+1);
            map.put(c, i);
        }

        return len;
    }

}
