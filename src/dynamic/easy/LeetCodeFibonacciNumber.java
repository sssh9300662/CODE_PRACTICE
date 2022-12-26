package dynamic.easy;

public class LeetCodeFibonacciNumber {

    public int fib(int n) {
        if(n ==0 || n==1){return n;}
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n ; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n];
    }

    public int fib2(int n) {
        if(n ==0 || n==1){return n;}
        return fib2(n-1) + fib2(n-2);
    }

    public static void main(String[] args){
        System.out.println(new LeetCodeFibonacciNumber().fib(4));
        System.out.println(new LeetCodeFibonacciNumber().fib2(4));
    }
}
