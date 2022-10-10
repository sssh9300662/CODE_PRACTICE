package slidingwindow;

/**
 * 給你字串 s 和整數 k 。
 * 請返回字串 s 中長度為 k 的單個子字串中可能包含的最大母音字母數。
 * 英文中的 母音字母 為（a, e, i, o, u）。
 * 示例 1：
 * 輸入：s = "abciiidef", k = 3
 * 輸出：3
 * 解釋：子字串 "iii" 包含 3 個母音字母。
 */
public class Example2 {

    public int maxVowels(String s, int k) {
        int right =0;
        int cur= 0;
        int max = 0;
        while (right < s.length()) {
            if(k == max){//結果以符合, 中斷
                return max;
            }
            if(isAEIOU(s.charAt(right))){
                cur++;
            }else{//不符合 重置
                cur = 0;
            }
            max = Math.max(max, cur);//紀錄當下結果
            right++;
        }
        return max;
    }

    public boolean isAEIOU(char s) {
        return s=='a' || s=='e' ||s=='i' ||s=='o' ||s=='u';
    }

    public static void main(String args[]){
        Example2 e = new Example2();
        System.out.println(e.maxVowels("abciiidef", 3));
        System.out.println(e.maxVowels("rhythms", 4));
        System.out.println(e.maxVowels("aeiou", 2));
        System.out.println(e.maxVowels("leetcode", 3));
        System.out.println(e.maxVowels("tryhard", 4));
    }
}
