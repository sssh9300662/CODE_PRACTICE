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
// It is guaranteed that every call to ping uses a strictly larger value of t th
//an the previous call. 
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
//recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], retur
//n 2
//recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], re
//turn 3
//recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,300
//2], return 3
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
    class RecentCounter {

        public RecentCounter() {}

        private int head = -1;

        private int pings = 0;

        private Queue<Integer> queue = new LinkedList<>();
    
        public int ping(int t) {
            if(head == -1){
                head = t;
            }
            queue.offer(t);
            pings = pings +1;
            while(t - head > 3000){
                queue.poll();
                head = queue.peek();
                pings = pings -1;
            }
            return pings;
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}