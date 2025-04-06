/**
Given n pairs of parentheses, write a function to generate all combinations of 
well-formed parentheses. 

 
 Example 1: 
 Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
 
 Example 2: 
 Input: n = 1
Output: ["()"]
 
 
 Constraints: 

 
 1 <= n <= 8 
 

 Related Topics String Dynamic Programming Backtracking 👍 21981 👎 1022

*/

package backtracking.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Time complexity: O(22n ⋅n)
 *
 * We are generating all possible strings of length 2n.
 * At each character, we have two choices: choosing ( or ), which means there are a total of 22n
 * unique strings.
 *
 * For each string of length 2n, we need to iterate through each character to
 * verify it is a valid combination of parentheses, which takes an average of O(n) time.
 *
 * 合法組合數 ≈ Catalan Number
 */
public class P22＿GenerateParentheses {

    List<String> result = new ArrayList<>();

    class Solution {
        public List<String> generateParenthesis(int n) {
            backtracking(new StringBuilder(), 0, 0, n);
            return result;
        }
    }

    private void backtracking(StringBuilder curString,
                              int leftCount, //使用過的左括號數量
                              int rightCount, // 使用過的右括號數量。
                              int n // 目標括號對數
    ) {
        // stop condition
        if(curString.toString().length() == n*2){
            result.add(curString.toString());
            return;
        }
        if(leftCount < n){
            curString.append("(");
            backtracking(curString, leftCount + 1, rightCount, n);
            curString.deleteCharAt(curString.length() - 1);
        }
        if(leftCount > rightCount){
            curString.append(")");
            backtracking(curString, leftCount, rightCount + 1, n);
            curString.deleteCharAt(curString.length() - 1);
        }
    }



    private boolean valid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() == 0;
    }
    public static void main(String[] args) {
        Solution solution = new P22＿GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
    }


}