package array;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 */
public class ValidAnagram {

    public static void main(String[] args){
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("racecar", "carrace"));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sArray = s.toLowerCase().toCharArray();
        char[] tArray = t.toLowerCase().toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return (new String(sArray)).equals(new String(tArray));
    }
}
