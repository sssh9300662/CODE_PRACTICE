package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 */
public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> history = new HashSet<>();
        for(int num: nums){
            if(history.contains(num)){
                return true;
            }
            history.add(num);
        }
        return false;
    }
}
