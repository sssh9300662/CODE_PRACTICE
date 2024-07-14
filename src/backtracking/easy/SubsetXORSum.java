package backtracking.easy;

// Is there a way to iterate through all the subsets of the array?
// Can we use recursion to efficiently iterate through all the subsets?
public class SubsetXORSum {
    public int ans = 0; //已經做出的選擇

    public int subsetXORSum2(int[] nums) {
        return getXORSum(0, 0, nums);
    }

    private int getXORSum(int start, int xor, int[] nums) {
        if(start == nums.length){
            return xor;
        }
        System.out.println("start=" + nums[start] + ", xor=" + xor);
        int sum = getXORSum(start+1, nums[start]^xor, nums);// 5,1 - 5, 1, 6 (跑到尾部)
        System.out.println("sum1=" + sum);
        sum = sum + getXORSum(start+1, xor, nums);//start = 下一個 6 , xor保留當前5
        System.out.println("sum2=" + sum);
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
        int[] num = {5,1,6};
        SubsetXORSum s = new SubsetXORSum();
        System.out.println(s.subsetXORSum(num));
        System.out.println(s.subsetXORSum2(num));
    }


}
