package slidingwindow;

/**
 * 給你兩個長度相同的字串，s 和 t。
 * 將 s 中的第 i 個字元變到 t 中的第 i 個字元需要 |s[i] - t[i]| 的開銷（開銷可能為 0），也就是兩個字元的 ASCII 碼值的差的絕對值。
 * 用於變更字串的最大預算是 maxCost。在轉化字串時，總開銷應當小於等於該預算，這也意味著字串的轉化可能是不完全的。
 * 如果你可以將 s 的子字串轉化為它在 t 中對應的子字串，則返回可以轉化的最大長度。
 * 如果 s 中沒有子字串可以轉化成 t 中對應的子字串，則返回 0。
 * 示例 1：
 * 輸入：s = "abcd", t = "bcdf", cost = 3
 * 輸出：3
 * 解釋：s 中的 "abc" 可以變為 "bcd"。開銷為 3，所以最大長度為 3。
 */
public class Example1 {

    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right =0;
        int sum = 0;
        int res = 0;
        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            right++;//右邊一直往前
            while (sum > maxCost) {
                sum -=  Math.abs(s.charAt(left) - t.charAt(left));// clear previous result
                left++; //不符合往前移動
            }
            res = Math.max(res, right -left);//記錄視窗
        }
        return res;
    }

    public static void main(String args[]){

    }
}
