package heap;

import java.util.PriorityQueue;

public class LeetCode215 {

    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public int findKthLargest(int[] nums, int k) {
        for(int num : nums){
            queue.offer(num);
        }
        while(queue.size() > k){
            queue.poll();
        }
        return queue.peek();
    }


    public static void main(String args[]){
        LeetCode215 lc = new LeetCode215();
        System.out.println(lc.findKthLargest(new int[]{4, 5, 8, 2}, 3));   // return 4
    }
}
