package compax;

/**
 * take the str parameter being passed and find the longest substring
 * that contains k unique characters, where k will be the first character
 * from the string. The substring will start from the second position
 * in the string because the first character will be the integer k.
 * For example: if str is "2aabbacbaa" there are several substrings
 * that all contain 2 unique characters, namely: ["aabba", "ac", "cb", "ba"],
 * but your program should return "aabba" because it is the longest substring.
 * If there are multiple longest substrings, then return the first substring
 * encountered with the longest length. k will range from 1 to 6.
 *
 * Input:"3aabacbebebe"
 * Output:"cbebebe"
 *
 * Input:"2aabbcbbbadef"
 * Output:"bbcbbb"
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchingChallenge {

    public SearchingChallenge() {
        // TODO Auto-generated constructor stub
    }

    public String lengthOfLongestSubstring(String s, int k) {
        String current = "";
        String max = "";
        int distinct = 0;
        int start = 0;
        while (start < s.length()) {
            for (int i = start; i < s.length(); i++) {
                String ch = s.substring(i, i + 1);
                if (current.contains(ch)) {
                    current = current + ch;
                    continue;
                }
                if (distinct + 1 > k) {
                    if (current.length() > max.length()) {
                        max = current;
                    }
                    distinct = 1;
                    current = ch;
                }else{
                    current = current + ch;
                    distinct++;
                }
            }
            if (current.length() > max.length()) {
                max = current;
            }
            distinct = 0;
            current = "";
            start++;
        }
        return max;
    }

    
    public static void main(String args[]) {
        String s = "3aabacbebebe";
        int k = Integer.parseInt(s.substring(0, 1));
        System.out.println(new SearchingChallenge().lengthOfLongestSubstring(s.substring(1), k));
        System.out.println(new SearchingChallenge().lengthOfLongestSubstring("aabbacbaa", 2));

    }}


