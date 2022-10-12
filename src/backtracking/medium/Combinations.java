package backtracking.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Constraints: 1 <= n <= 20, 1 <= k <= n
 */
public class Combinations {

    List<List<Integer>> result = new LinkedList<>();

    /**
     *
     * @param n 可以做的選擇(選擇清單)
     * @param k 終止條件
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>(); //已經做出的選擇
        backtrack(path, 1, n, k);
        return result;
    }

    private void backtrack(LinkedList<Integer> path, int start, int n, int k) {
        if(path.size() == k){//終止條件, 選擇是否符合要求
            result.add(new LinkedList<>(path));
            return;
        }
        for(int i=start; i <= n; i++){
            path.add(i);//選擇
            backtrack(path, i+1, n, k);
            path.removeLast();//清空,從選擇清單做下一個選擇
        }
    }

    public static void main(String args[]){
        Combinations c = new Combinations();
        System.out.println(c.combine(4,2));
    }
}
