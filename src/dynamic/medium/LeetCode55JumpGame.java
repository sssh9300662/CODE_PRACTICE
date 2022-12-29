package dynamic.medium;

public class LeetCode55JumpGame {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return false;
        }
        int max = 0;
        for(int i=0; i < length;i++){
            if(i > max){//現在位置,當前最多可前進位置無法到達
                return false;
            }
            if(max >= length){//當前最多可前進位置, 已經可以到最後了
                return true;
           }
            int curMaxSteps = nums[i];//當前最多可走步數
            max = Math.max(max, i +curMaxSteps);//之前最多可前進位置, 和當前最多可前進位置
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode55JumpGame().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new LeetCode55JumpGame().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new LeetCode55JumpGame().canJump(new int[]{0}));
        System.out.println(new LeetCode55JumpGame().canJump(new int[]{2,5,0,0}));
    }
}
