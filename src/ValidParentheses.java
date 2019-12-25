import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    
    private HashMap<String, String> mappings;
    
    {
        this.mappings = new HashMap<String, String>();
        this.mappings.put(")", "(");
        this.mappings.put("}", "{");
        this.mappings.put("]", "[");
    }

    public ValidParentheses() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();
        for(int i =0; i < s.length(); i++) {
            String element = String.valueOf(s.charAt(i));
            if(this.mappings.containsKey(element)) {
                String value = "*";
                if(stack.isEmpty() == false) {
                    value = stack.pop();
                }else {
                    return false;
                }
                if(value.equals(this.mappings.get(element))) {
                    continue;
                }else {
                    return false;
                }
            }else {
                stack.push(element);
            }
        }
        if(stack.empty()) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("("));
    }

}
