//You have a RecentCounter class which counts the number of recent requests with
//in a certain time frame. 
//
// Implement the RecentCounter class: 
//
// 
// RecentCounter() Initializes the counter with zero recent requests. 
// int ping(int t) Adds a new request at time t, where t represents some time in
// milliseconds, and returns the number of requests that has happened in the past 
//3000 milliseconds (including the new request). Specifically, return the number o
//f requests that have happened in the inclusive range [t - 3000, t]. 
// 
//
// It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
//
// 
// Example 1: 
//
// 
//Input
//["RecentCounter", "ping", "ping", "ping", "ping"]
//[[], [1], [100], [3001], [3002]]
//Output
//[null, 1, 2, 3, 3]
//
//Explanation
//RecentCounter recentCounter = new RecentCounter();
//recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
//recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
//recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
//recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= t <= 109 
// Each test case will call ping with strictly increasing values of t. 
// At most 104 calls will be made to ping. 
// 
// Related Topics Design Queue Data Stream 
// 👍 836 👎 2564

package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

//Java：Number of Recent Calls
public class P933NumberOfRecentCalls{

    public static void main(String[] args) {
        RecentCounter solution = new P933NumberOfRecentCalls().new RecentCounter();
        System.out.println(solution.ping(642));
        System.out.println(solution.ping(1849));
        System.out.println(solution.ping(4921));
        System.out.println(solution.ping(5936));
        System.out.println(solution.ping(5957));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Since the elements in our sliding window are strictly ordered, due to the condition of the problem,
     * one might argue that it might be more efficient to use binary search to locate the most recent outdated calls
     * and then starting from that point truncate all the previous calls.
     *
     * In terms of search, binary search is seemingly more efficient than our linear search.
     * When the elements are held in the array data structure, it is true that binary search is more efficient.
     *
     * However, it is not the case for the linked list, since there is no way to locate an element
     * in the middle of a linked list instantly, which is a critical condition for binary search algorithm.
     *
     * As a result, in order to apply binary search, we might have to opt for the Array data structure.
     * On the other hand, once we use the array as the container, we might have to keep all the historical elements,
     * which in the long run is not space-efficient neither time-efficient later.
     * Or we have to find a way to efficiently remove the elements from array without frequently reallocating memory.
     *
     * To conclude, it is doable to have a binary search solution.
     * Yet, it would complicate the design, and at the end the final solution is not necessarily
     * more efficient than the above simple LinkedList-based sliding window.
     */
    class RecentCounter {

        public RecentCounter() {}

        private Queue<Integer> queue = new LinkedList<>();
    
        public int ping(int t) {
            queue.offer(t); // Appending: we will append each incoming call to the tail of the sliding window.
            while(t - queue.peek() > 3000){ // Popping: we need to pop out all the outdated calls from
                // the head of the sliding window.
                //  once the ping calls become outdated, i.e. out of the scope of [t-3000, t],
                //  we do not need to keep them any longer in the container, since they will not contribute to the solution later.
                queue.poll();
            }
            return queue.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}