package string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
 *
 * Please implement encode and decode
 *
 * Example 1:
 *
 * Input: ["neet","code","love","you"]
 *
 * Output:["neet","code","love","you"]
 * Example 2:
 *
 * Input: ["we","say",":","yes"]
 *
 * Output: ["we","say",":","yes"]
 */
public class EncodeAndDecode {

    private static final String delimiter = "#";

    public static void main(String args[]){
        EncodeAndDecode obj = new EncodeAndDecode();
        String[] strs = new String[]{"we","say",":","yes","!@#$%^&*()"};
        String encode = obj.encode(Arrays.asList(strs));
        System.out.println(encode);
        System.out.println(obj.decode(encode));
    }


    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        for (int size : sizes) {
            res.append(size).append(',');
        }
        res.append('#');
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for (int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;
    }
}
