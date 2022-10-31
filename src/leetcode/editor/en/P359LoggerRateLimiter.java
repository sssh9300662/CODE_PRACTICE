package leetcode.editor.en;

import java.util.HashMap;

//Java：Logger Rate Limiter
public class P359LoggerRateLimiter{

    public static void main(String[] args) {
        Logger logger = new P359LoggerRateLimiter().new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Logger {

        private HashMap<String, Integer> msgMap = new HashMap<>();

        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if(msgMap.containsKey(message)) {
                if(timestamp - msgMap.get(message) < 10) {
                    return false;
                }
            }
            msgMap.put(message, timestamp);
            return true;
        }
    }
}