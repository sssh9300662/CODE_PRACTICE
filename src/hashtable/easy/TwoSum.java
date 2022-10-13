package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            int cur = nums[i]; // 當前元素
            int need = target -cur; // 需要哪個元素match
            if(map.containsKey(need)){//是否之前已經處理過
                return new int[] { map.get(need), i }; // 解答
            }
            map.put(cur, i); //將當前元素將入集合, 處理下一個元素
        }
        return null;
    }
}
