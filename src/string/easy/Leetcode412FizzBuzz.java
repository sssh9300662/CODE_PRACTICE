package string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class Leetcode412FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(int i =1; i <= n; i++){
            if(i % (3*5) == 0){
                answer.add("FizzBuzz");
                continue;
            }
            if(i % 3 == 0){
                answer.add("Fizz");
                continue;
            }
            if(i % 5 == 0){
                answer.add("Buzz");
                continue;
            }
            answer.add(String.valueOf(i));
        }
        return answer;
    }
}
