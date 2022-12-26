package dynamic.easy;

public class LeetCode70ClimbingStairs {

    public int climbStairs(int n) {
        if(n==0 || n==1) return n;
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for(int i=2; i <=n; i++){
            array[i] = array[i-1] + array[i-2];
        }
        return array[n] + array[n-1];
    }

    public static void main(String[] args){
        System.out.println(new LeetCode70ClimbingStairs().climbStairs(4));
    }
}
