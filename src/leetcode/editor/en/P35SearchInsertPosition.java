// Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
//Input: nums = [1,3,5,6], target = 5
//Output: 2
//
// Example 2:
//Input: nums = [1,3,5,6], target = 2
//Output: 1
//
// Example 3:
//Input: nums = [1,3,5,6], target = 7
//Output: 4
// 
// Constraints:
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 10687 👎 502

package leetcode.editor.en;
//Java：Search Insert Position
public class P35SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = (start + end) >>> 1;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid +1;
                continue;
            }
            end = mid -1;
            continue;
        }
        return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}