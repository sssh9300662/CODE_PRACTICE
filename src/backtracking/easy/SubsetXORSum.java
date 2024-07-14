package backtracking.easy;

// Is there a way to iterate through all the subsets of the array?
// Can we use recursion to efficiently iterate through all the subsets?
public class SubsetXORSum {
    public int ans = 0; //已經做出的選擇

    public int subsetXORSum2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i =0; i < nums.length; i++){
            sum += getXORSum(i, nums);
        }
        return sum;
    }

    private int getXORSum(int start, int[] nums) {
        int sum = 0;
        int xor = 0;
        for(int i = start; i < nums.length; i++){
            xor = nums[i]^xor;
            sum += xor;
            if(i == nums.length-1){//終止條件(邊界條件)
                xor = 0;
                start++;
            }
        }
        System.out.println("sum=" + sum);
        return sum;
    }

    public int subsetXORSum(int[] nums) {
        func(nums, 0, 0);
        return ans;
    }

    private void func(int[] nums, int start, int xor) {
        if(start == nums.length){//終止條件, 選擇是否符合要求 (走到最後了)
            ans += xor;
            return;
        }
        xor^=nums[start]; //選擇
        func(nums, start + 1, xor);//同number,繼續往前走
        xor^=nums[start]; //清空選擇
        func(nums, start + 1, xor); //重置但移除之前的選擇
    }

    public static void main(String args[]){
        int[] num = {5, 1,6};
        SubsetXORSum s = new SubsetXORSum();
        System.out.println(s.subsetXORSum(num));
        System.out.println(s.subsetXORSum2(num));
    }


}
