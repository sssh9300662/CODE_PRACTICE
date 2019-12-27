import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public LongestSubstringWithoutRepeating() {
        // TODO Auto-generated constructor stub
    }
    
    public int lengthOfLongestSubstring(String s) {
        int counter = 0;
        String max = "";
        for(; counter < s.length(); counter++) {
            String current = String.valueOf(s.charAt(counter));
            if(current.length() > max.length()) {
                max = current;
            }
            for(int j = counter+1; j < s.length(); j++) {
                String next = String.valueOf(s.charAt(j));
                if(current.contains(next)) {
                    break;
                }
                current = current + next;
                if(current.length() > max.length()) {
                    max = current;
                }
            }
        }
        return max.length();
    }
    
    public static void main(String args[]) {
        LongestSubstringWithoutRepeating obj = new LongestSubstringWithoutRepeating();
        System.out.println(obj.lengthOfLongestSubstring("dvdf"));
    }

}
