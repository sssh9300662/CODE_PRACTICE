package divideAndConquer.medium;

import java.util.Arrays;

public class LeetCode53MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int start = 0; //inclusive
        int end = 1; //exclusive
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxSumStartIndex = 0;
        int maxSumEndIndex = 0;
        while (start < end && end <= nums.length)
        {
            sum += nums[end - 1];
            if(sum > max){
                maxSumStartIndex = start;
                maxSumEndIndex = end-1;
                max = sum;
            }
            if (sum <= 0)
            {
                start = end;
                sum = 0;
            }
            end++;
        }
        System.out.println("##############");
        System.out.println(maxSumStartIndex);
        System.out.println(maxSumEndIndex);
        System.out.println("##############");
        return max;
    }

    public static void main(String[] args){
        LeetCode53MaximumSubarray lc = new LeetCode53MaximumSubarray();
        System.out.println(lc.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(lc.maxSubArray(new int[]{-1, 0, -2}));
    }
}
