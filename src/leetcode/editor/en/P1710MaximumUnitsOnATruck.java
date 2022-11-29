//You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes,
// where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
//
// numberOfBoxesi is the number of boxes of type i. 
// numberOfUnitsPerBoxi is the number of units in each box of the type i. 
//
// You are also given an integer truckSize, which is the maximum number of boxes
// that can be put on the truck. You can choose any boxes to put on the truck as long as the
// number of boxes does not exceed truckSize.
//
// Return the maximum total number of units that can be put on the truck. 

// Example 1:
//Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//Output: 8
//Explanation: There are:
//- 1 box of the first type that contains 3 units.
//- 2 boxes of the second type that contain 2 units each.
//- 3 boxes of the third type that contain 1 unit each.
//You can take all the boxes of the first and second types, and one box of the third type.
//The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
//
// Example 2:
//Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//Output: 91
// 
// Constraints:
// 1 <= boxTypes.length <= 1000 
// 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000 
// 1 <= truckSize <= 106 
// 
// Related Topics Array Greedy Sorting 
// 👍 3228 👎 182

package leetcode.editor.en;

import java.util.Arrays;

//Java：Maximum Units on a Truck
public class P1710MaximumUnitsOnATruck{
    public static void main(String[] args) {
        Solution solution = new P1710MaximumUnitsOnATruck().new Solution();
        System.out.println(solution.maximumUnits(new int[][]{new int[]{1,3}, new int[]{2,2},
                        new int[]{3,1}}, 4));
        System.out.println(solution.maximumUnits(new int[][]{new int[]{5,10}, new int[]{2,5},
                new int[]{4,7}, new int[]{3,9}}, 10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
            int totalUnit = 0;
            for(int[] boxType : boxTypes){
                Integer amount = boxType[0];
                Integer unit = boxType[1];
                if(amount >= truckSize){
                    return totalUnit + (truckSize * unit);
                }
                truckSize = truckSize - amount;
                totalUnit = totalUnit + (amount * unit);
            }
            return totalUnit;
        }
    }
}