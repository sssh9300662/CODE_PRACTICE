

public class RomanToInteger {
    
    public int tokenVal(Character s) {
        switch (s) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    
    
    public int romanToInt(String s) {
        int val = 0;
        int ithChar = 0;
        int sLength = s.length();
        char currentChar;
        char nextChar;
        
        while (ithChar < sLength) {
            currentChar = s.charAt(ithChar);
            nextChar = ithChar + 1 < sLength ? s.charAt(ithChar + 1) : ' ';
            int currentCharVal = tokenVal(currentChar);
            int nextCharVal = tokenVal(nextChar);
            if (currentCharVal < nextCharVal) {
                val += (nextCharVal - currentCharVal);
                ithChar += 2;
            } else {
                val += tokenVal(currentChar);
                ithChar++;
            }         
        }
        return val;
    }

    public RomanToInteger() {
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
