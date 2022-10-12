package backtracking.easy;

public class SubsetXORSum {
    public int ans = 0; //已經做出的選擇

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
    }


}
