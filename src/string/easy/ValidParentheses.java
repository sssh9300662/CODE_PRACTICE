package string.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    
    private HashMap<Character, Character> mappings;
    
    {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public ValidParentheses() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i < s.length(); i++) {
            Character element = s.charAt(i);
            if(this.mappings.containsKey(element)) {
                if(stack.isEmpty()) {// post character cannot appear first
                    return false;
                }
                Character preValue = stack.pop();
                if(preValue.equals(this.mappings.get(element))) {// can match, e.g. (), {}, []
                    continue;
                }else {//必須成對, 所以post symbol not match pre character直接判斷不合規定
                    return false;
                }
            }else {
                stack.push(element);// pre character push value directly
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("{()}"));
    }

}
