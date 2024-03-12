package binarytree;

import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode347TopKFrequentElements {

    public static void main(String[] args){
        LeetCode347TopKFrequentElements instance = new LeetCode347TopKFrequentElements();
        int[] result = instance.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for(int value : result){
            System.out.println(value);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // Record the frequency of each number
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Define sorting rule
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a)); // big to small
        for(int num : map.keySet()){// value of key set is uniqueue, we should avoid count duplicate number
            pq.add(num);
        }
        int cur = 0;
        int[] result = new int[k];
        while(cur < k){
            result[cur++] = pq.poll();
        }
        return result;
    }
}
