//In a town, there are n people labeled from 1 to n. There is a rumor that one of these people
// is secretly the town judge.
//
// If the town judge exists, then:
// The town judge trusts nobody. 
// Everybody (except for the town judge) trusts the town judge. 
// There is exactly one person that satisfies properties 1 and 2.
//
// You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai
// trusts the person labeled bi. Return the label of the town judge if the town judge exists
// and can be identified or return -1 otherwise.
// 
// Example 1:
//Input: n = 2, trust = [[1,2]]
//Output: 2
//
// Example 2:
//Input: n = 3, trust = [[1,3],[2,3]]
//Output: 3
//
// Example 3:
//Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//Output: -1
// 
// Constraints:
// 1 <= n <= 1000 
// 0 <= trust.length <= 104 
// trust[i].length == 2 
// All the pairs of trust are unique. 
// ai != bi 
// 1 <= ai, bi <= n 
// 
// Related Topics Array Hash Table Graph 
// 👍 4064 👎 299

package leetcode.editor.en;

import java.util.*;

//Java：Find the Town Judge
public class P997FindTheTownJudge{
    public static void main(String[] args) {
        Solution solution = new P997FindTheTownJudge().new Solution();
        System.out.println(solution.findJudge2(2, new int[][]{
                {1,2}
        }));
        System.out.println(solution.findJudge2(3, new int[][]{
                {1,3},{2,3}
        }));
        System.out.println(solution.findJudge2(3, new int[][]{
                {1,3},{2,3},{3,1}
        }));
        System.out.println(solution.findJudge2(1, new int[][]{}));
        System.out.println(solution.findJudge2(4, new int[][]{
                {1,3},{1,4}, {2,3},{2,4},{4,3}
        }));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int judgeScore = n-1;
        Map<Integer, Set<Integer>> judgeMap = new HashMap<>();
        Set<Integer> noneJudge = new HashSet<>();
       for(int[] side : trust){
           int start = side[0];
           int end = side[1];
           noneJudge.add(start);
           judgeMap.remove(start);
           if(noneJudge.contains(end)){
               continue;
           }
           Set<Integer> path = judgeMap.get(end);
           if(path == null){
               path = new HashSet<>();
           }
           path.add(start);
           judgeMap.put(end, path);
       }
       for(int key: judgeMap.keySet()){
           int score = judgeMap.get(key).size();
           if(score == judgeScore){
               return key;
           }
       }
       return -1;
    }

    public int findJudge2(int n, int[][] trust) {
        if(trust.length < n-1){ // valid trust degree is N-1
            return -1;
        }
        int[] in = new int[n+1];// default array element = 0
        int[] out = new int[n+1];
        for(int[] edge : trust){
            out[edge[0]]++;
            in[edge[1]]++;
        }
        for(int i=1; i <= n; i++){
            if(out[i] == 0 && in[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}