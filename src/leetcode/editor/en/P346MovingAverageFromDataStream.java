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
//
// 
// Constraints: 
//
// 
// 1 <= size <= 1000 
// -105 <= val <= 105 
// At most 104 calls will be made to next. 
// 
// Related Topics Array Design Queue Data Stream 
// 👍 1416 👎 139

package leetcode.editor.en;

import java.util.ArrayList;

//Java：Moving Average from Data Stream
public class P346MovingAverageFromDataStream{

    public static void main(String[] args) {
        MovingAverage solution = new P346MovingAverageFromDataStream().new MovingAverage(3);
        System.out.println(solution.next(1));
        System.out.println(solution.next(10));
        System.out.println(solution.next(3));
        System.out.println(solution.next(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {

        private ArrayList<Integer> queue = new ArrayList<>();

        private int size;

        public MovingAverage(int size) {
            this.size = size;
        }
    
        public double next(int val) {
            queue.add(val);
            int queueSize = queue.size();
            int skip = (queueSize - size) > 0 ?(queueSize - size):0;
            Double sum = 0.0;
            int window = 0;

            for(int i = skip; i < queue.size(); i++){
                if(window == size){
                    break;
                }
                int cur = queue.get(i);
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