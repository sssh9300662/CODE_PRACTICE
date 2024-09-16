package epam;

/**
 * Consider a string of lowercase characters that contains 0 or more vowels.
 */
public class CountTheNumberOfVowels {

    public static void main(String args[]){
        CountTheNumberOfVowels c = new CountTheNumberOfVowels();
        System.out.println(c.solution("Scaler"));

    }

    public long solution(String s){
        int n= s.length();
        long[] occur = new long[n];

        if(n == 0){
            return 0L;
        }
        for(int i=0; i < n; i++){
            if(i == 0){
                occur[i] = n; // occur in every length of substring
            }else{
                occur[i] = (n-i) + occur[i-1] -i; //occur in every length of substring
                // + (pre occurrence definitely include current char)
                // - (only single pre char that, they are in pre occurrence but definitely not include current char)
            }
        }
        long count = 0L;
        for(int i=0; i < n; i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch == 'e' || ch == 'i' || ch=='o' || ch =='u'){
                count += occur[i];
            }
        }
        return count;
    }
}
