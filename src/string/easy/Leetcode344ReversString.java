package string.easy;

public class Leetcode344ReversString {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args){
        Leetcode344ReversString s = new Leetcode344ReversString();
        char[] chs = new char[]{'h','e','l','l','o'};
        s.reverseString(chs);
        System.out.println(chs);
    }
}
