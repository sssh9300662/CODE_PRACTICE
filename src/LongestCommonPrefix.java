import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LongestCommonPrefix {

    public LongestCommonPrefix() {
        // TODO Auto-generated constructor stub
    }
    
    
    public String longestCommonPrefix(String[] strs) {
        Set<String> candidates = new HashSet<String>();
        String sample = strs[0];
        String result = "";
        
        for(int i =0; i<sample.length();i++) {
            String candidate = sample.substring(0, i+1);
            boolean isNotQualified = false;
            for(String str : strs) {
                if(!str.startsWith(candidate)) {
                    isNotQualified = true;
                    break;
                }
            }
            if(!isNotQualified && (candidate.length() > result.length())) {
                result = candidate;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] values = {"dog","racecar","car"};
        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(values));

    }

}
