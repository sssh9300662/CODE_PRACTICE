package dynamic.medium;

import dynamic.easy.LeetCode70ClimbingStairs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 * 簡單來說，這題想要找的是最大乘積的子陣列。
 * - 每回合的最大值是當下的最大值與目前值找最大的
 * - 因為是乘積，當中又有負數會來攪局
 * - 這裡除了每次紀錄當下的最大值以外呢，也要同時紀錄當下的最小值，以免下一回合直接乘上負數
 *  - 切小的問題會是，每回合找最大值與最小值，而且最大最小值的找法為：
 *      最大值：max (目前值、上一回合 max * 目前值、上一回合 min * 目前值)
 *      最小值：min (目前值、上一回合 max * 目前值、上一回合 min * 目前值)
 *  - 這裡就會需要分別一個紀錄 max 與 min 的表，每回合我們只需要查表找出上一回合的最大最小值，並且更新這回合的值
 */
public class LeetCodeMaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        int[] records = new int[nums.length];
        while(start < nums.length){
            int curProduct = 1;
            records[start]= Integer.MIN_VALUE;
            for(int i=start; i < nums.length; i++){
                int cur = nums[i];
                curProduct = curProduct * cur;
                if(curProduct > records[start]){
                    records[start] = curProduct;
                } else if (cur > records[start]) {
                    records[start] = cur;
                }
                if(curProduct == 0 || i == nums.length-1){
                    int curMax = records[start];
                    if(curMax > max){
                        max = curMax;
                    }
                }
            }
            start ++;
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        if (nums.length == 0) return 0;
        int curMax = nums[0];
        int curMin = nums[0];
        int globalMax = nums[0];
        for(int i=1; i < nums.length; i++){
            int cur = nums[i];
            int tempMax = Math.max(cur, Math.max(curMax*cur,curMin*cur));
            curMin = Math.min(cur, Math.min(curMax*cur,curMin*cur));
            curMax = tempMax;
            globalMax = Math.max(curMax, globalMax);
        }
        return globalMax;
    }

    public static void main(String[] args){
        System.out.println(new LeetCodeMaximumProductSubarray().maxProduct2(new int[]{2,-5,-2,-4,3}));
        System.out.println(new LeetCodeMaximumProductSubarray().maxProduct3(new int[]{2,-5,-2,-4,3})); // 額外迴圈
        System.out.println(new LeetCodeMaximumProductSubarray().maxProduct5(new int[]{2,-5,-2,-4,3}));
    }

    public int maxProduct5(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return nums[0];
        int result = nums[0]; // 紀錄最大,不參與計算
        int curMax = nums[0]; // 累積
        int curMin = nums[0]; // 累積
        for(int i=1; i < length; i++){
            int cur = nums[i]; // 當前數值可以reset max & min
            /**
             * cur 最大 -> reset 之前紀錄
             * cur * curMax -> 正累積
             * cur * curMin -> 之前負數, rest 之前最大
             */
            int tempMax = Math.max(cur, Math.max(cur * curMin, cur * curMax)); // 之前成績和當前比較
            System.out.println("tempMax=" + tempMax);
            /**
             * cur 最小 -> 更新最小
             * cur * curMax -> rest
             * cur * curMin -> 正累積
             */
            curMin = Math.min(cur, Math.min(cur * curMin, cur * curMax));
            curMax = tempMax;
            System.out.println("curMin=" + curMin);
            System.out.println("curMax=" + curMax);
            result = Math.max(result, curMax);
        }
        return result;
    }

    public int maxProduct3(int[] nums) {
        if(nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++){
            int curMax = findMax(i, nums);
            if(curMax > max){
                max = curMax;
            }
        }
        return max;
    }

    private int findMax(int position, int[] nums){
        int cur = nums[position];
        int max = cur;
        for(int i=position+1; i < nums.length; i++){
            cur = cur * nums[i];
            if(cur > max){
                max = cur;
            }
        }
        return max > cur ? max : cur;
    }
}
