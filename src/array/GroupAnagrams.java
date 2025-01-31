package array;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args){
        String[] strs = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String str : strs){
            int[] frequency = new int[26];
            char[] chars = str.toCharArray();
            for(char ch : chars){
                int v = ch - 'a';
                frequency[v] = frequency[v] + 1;
            }
           String key = Arrays.toString(frequency);
            if(groupMap.containsKey(key)){
                groupMap.get(key).add(str);
            }else {
                List<String> value = new ArrayList<>();
                value.add(str);
                groupMap.put(key, value);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : groupMap.entrySet()){
            result.add(entry.getValue());
        }
        return result;

    }
}
