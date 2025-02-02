package string.easy;

/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Example 1:
 *
 * Input: s = "Was it a car or a cat I saw?"
 *
 * Output: true
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return false;
        }
        if(s.length() == 1){
            return true;
        }
        s = s.trim().toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            char pre = s.charAt(start);
            if(!Character.isLetterOrDigit(pre)){
                start++;
                continue;
            }
            char last = s.charAt(end);
            if(!Character.isLetterOrDigit(last)){
                end--;
                continue;
            }
            if(pre != last){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
