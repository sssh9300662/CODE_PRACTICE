// Given a stream of integers and a window size, calculate the moving average of all integers in
// the sliding window.
//
// Implement the MovingAverage class:
// MovingAverage(int size) Initializes the object with the size of the window size.
// double next(int val) Returns the moving average of the last size values of the stream.
// 
// Example 1:
// 
//Input
//["MovingAverage", "next", "next", "next", "next"]
//[[3], [1], [10], [3], [5]]
//Output
//[null, 1.0, 5.5, 4.66667, 6.0]
//
//Explanation
//MovingAverage movingAverage = new MovingAverage(3);
//movingAverage.next(1); // return 1.0 = 1 / 1
//movingAverage.next(10); // return 5.5 = (1 + 10) / 2
//movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
//movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
// 
// Constraints:
// 1 <= size <= 1000 
// -105 <= val <= 105 
// At most 104 calls will be made to next. 
// 
// Related Topics Array Design Queue Data Stream 
// 👍 1416 👎 139

package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Java：Moving Average from Data Stream
public class P346MovingAverageFromDataStream{

    public static void main(String[] args) {
        MovingAverage solution = new P346MovingAverageFromDataStream().new MovingAverage(3);
        System.out.println(solution.next(1));
        System.out.println(solution.next(10));
        System.out.println(solution.next(3));
        System.out.println(solution.next(5));
    }

    class MovingAverage{

        private int size;

        private double currSum = 0.0;

        private int index = 0;

        private int window = 0;

        private int[] queue;
        public MovingAverage(int size){
            this.size = size;
            this.queue = new int[size];
        }

        public double next(int val) {
            index = (index + 1)%size; // find current val's index (head)
            currSum = currSum + val - queue[index];
            queue[index] = val;
            if(window < size){
                window++;
            }
            return currSum/window;
        }

        }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage2 {

        private int[] circularQueue;

        private int size;

        public MovingAverage2(int size) {
            this.size = size;
            this.circularQueue = new int[size];
        }
    
        public double next(int val) {
            return circularQueueWithArray(val);
        }

        private Double curSum = 0.0;

        private int window = 0;

        private int index = 0;

        private double circularQueueWithArray(int val){
            index = (index + 1)%size; // find current val's index (head)
            curSum =  curSum  + val - circularQueue[index];
            circularQueue[index] = val;
            if(window < size){// increase window size
                window = window + 1;
            }
            return curSum/window;
        }

        /**
         * Double-ended Queue
         * Time Complexity: O(1)\mathcal{O}(1)O(1), as we can see that there is no loop in the next(val) function.
         * Space Complexity: O(N)\mathcal{O}(N)O(N), where NNN is the size of the circular queue.
         * @param val
         * @return
         */
        private Queue<Integer> queue = new LinkedList<>();

        private double dequeue(int val) {
            queue.offer(val); // add value to queue
            curSum =  curSum  + val; // accumulate
            if(window < size){// increase window size
                window = window + 1;
            }else{// if reach window size, it means we don't need extra item since number of
                // items is limited by window szie
                curSum = curSum - queue.poll();
            }
            return curSum/window;
        }

        private ArrayList<Integer> list = new ArrayList<>();

        private double arrayListSolution(int val) {
            list.add(val);
            int window = 0;
            int queueSize = list.size();
            int skip = (queueSize - size) > 0 ?(queueSize - size):0; // number of item we should
            // calculate is based on window size, since we only need previous data based on
            // current value index, so we should know how many previous items we should skip
            Double sum = 0.0;
            for(int i = skip; i < list.size(); i++){
                if(window == size){
                    break;
                }
                int cur = list.get(i);
                sum = sum + cur;
                window = window +1;
            }
            return sum/window;
        }
    }
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
}