package multithread;

/**
 * 兩個thread循環輸出不同字元, 但有順序, 其中一個線程需等另一個線程完才能執行
 * e.g. ABABABAB
 */
public class Case1 {

    static class OrderedPrinter {
        private boolean isATurn = true; // 先讓 A 先執行

        public synchronized void printA() {
            for (int i = 0; i < 10; i++) { // 打印10次
                while (!isATurn) { // 不是 A 的回合就等待
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print("A"); // 輸出 "A"
                isATurn = false; // 交給 B 執行
                notify(); // 喚醒等待的 B
            }
        }

        public synchronized void printB() {
            for (int i = 0; i < 10; i++) { // 打印10次
                while (isATurn) { // 不是 B 的回合就等待
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print("B"); // 輸出 "B"
                isATurn = true; // 交給 A 執行
                notify(); // 喚醒等待的 A
            }
        }
    }

    public static void main(String[] args) {
        OrderedPrinter printer = new OrderedPrinter();

        Thread threadA = new Thread(printer::printA);
        Thread threadB = new Thread(printer::printB);

        threadA.start();
        threadB.start();
    }
}
