//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// 
// Example 1:
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
// Example 2:
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
// Example 3:
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
// Constraints:
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists.
// 
//Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity? Related Topics Array Hash Table
// 👍 38843 👎 1246

package leetcode.editor.en;

//Java：Two Sum
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        int[] result = solution.twoSum(new int[]{3,2,4}, 6);
        for(int val : result){
            System.out.println(val);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2]; // Save result
        func(0, target, nums, result);
        return result;
    }

        /**
         * backtrack solution
         * @param curIndex
         * @param target
         * @param nums
         * @param result
         */
    private void func(int curIndex , int target, int[] nums, int[] result){
        if(curIndex == nums.length){//最後一個元素不需要處理
            return;
        }
        for(int i=curIndex+1; i < nums.length; i++){//固定cur, 一直往下走
            int val = nums[curIndex] + nums[i]; //和下一個元素相加
            if(val == target){// 符合直接存結果
                result[0] = curIndex;
                result[1] = i;
                return;
            }
        }
        func(curIndex +1, target, nums, result); // 換下一個cur
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}