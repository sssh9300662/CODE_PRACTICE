package heap;

import java.util.PriorityQueue;

public class LeetCode703 {
    private int targetIndex;

    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public LeetCode703 (int k, int[] nums) {
        for(int num : nums){
            queue.offer(num);
        }
        this.targetIndex = k;
        while(queue.size() > targetIndex){
            queue.poll();
        }
    }

    public int add(int val) {
        this.queue.offer(val);
        if (queue.size() > targetIndex) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String args[]){
        LeetCode703 lc = new LeetCode703(3, new int[]{4, 5, 8, 2});
        System.out.println(lc.add(3));   // return 4
        System.out.println(lc.add(5));   // return 5
        System.out.println(lc.add(10));  // return 5
        System.out.println(lc.add(9));   // return 8
        System.out.println(lc.add(4));   // return 8
    }
}
