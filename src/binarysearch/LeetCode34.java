package binarysearch;

import backtracking.easy.SubsetXORSum;

public class LeetCode34 {

    public static void main(String[] args){
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] result = new LeetCode34().searchRange(nums, 8);
        for(int i : result){
            System.out.println(i);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int firstFound = searchInsert(nums, target, 0, nums.length -1, true);
        if(firstFound == -1){
            return new int[]{-1, -1};
        }
        int endIndex = searchInsert(nums, target, firstFound, nums.length -1, false);
        return new int[]{firstFound, endIndex};
    }

    /**
     * 找到目標後, 還需要確認左右元素！！
     * @param nums
     * @param target
     * @param start
     * @param end
     * @param findLowerBound
     * @return
     */
    private int searchInsert(int[] nums, int target, int start, int end, boolean findLowerBound) {
        int left = start;
        int right = end;
        while(left <= right){
            int mid = (left + right)/2;
            int cur = nums[mid];
            if(cur == target){
                if(findLowerBound){
                    // This means we found our lower bound.
                    if (mid == left || nums[mid - 1] != target) {
                        return mid;
                    }
                    right = mid -1;
                }else{
                    if (mid == right || nums[mid + 1] != target) {
                        return mid;
                    }
                    left = mid+1;
                }
            } else if(cur < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
