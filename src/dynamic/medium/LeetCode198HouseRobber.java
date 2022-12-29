package dynamic.medium;

public class LeetCode198HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] rob = new int[n];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            rob[i] = Math.max(rob[i-1], rob[i-2] + nums[i]);
        }
        return rob[n-1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        else if(n==1)
            return nums[0];
        int prevTwo = nums[0]; // house i-2
        int prevOne = nums[1]; // house i-1
        for(int i=2;i<n;i++)
        {
            int cur = Math.max(prevTwo+nums[i], prevOne);
            prevTwo = Math.max(prevTwo, prevOne);
            prevOne = Math.max(prevOne, cur);
        }
        return Math.max(prevOne,prevTwo);
    }

    public static void main(String[] args){
        System.out.println(new LeetCode198HouseRobber().rob2(new int[]{1,2,3,1}));
        System.out.println(new LeetCode198HouseRobber().rob2(new int[]{2,7, 9, 3,1}));
        System.out.println(new LeetCode198HouseRobber().rob2(new int[]{4,1,2,7,5,3,1}));
    }
}
