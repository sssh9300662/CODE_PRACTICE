import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCPattern {
	
	private static Lock lock = new ReentrantLock();

	static class Warehouse {
		private static final int capacity = 3;
		private final Queue<Integer> products = new LinkedList<Integer>();
		private boolean occupied = false; 

		void add(Integer product) throws InterruptedException {
			lock.lock(); 
			try{
				while (products.size() < capacity) {
					System.out.println("Produce " + product);
					products.offer(product);
				}
			}finally{
				lock.unlock();
			}
		}

		Integer get(){
			lock.lock(); 
			int product = 0;
			try{
				while (products.size() > 0) {
					product = products.poll();
				}
				occupied = true;
			}finally{
				lock.unlock();
			}
			return product;
		}
	}

	static class Producer implements Runnable {
		private Warehouse warehouse;

		Producer(Warehouse warehouse) {
			this.warehouse = warehouse;
		}

		public void run() {
			for (int product = 1; product <= 10; product++) {
				try {
	                Thread.sleep((int) Math.random()*1000);
	            }
	            catch(InterruptedException e) {
	                e.printStackTrace();
	            }
				try {
					warehouse.add(product);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Consumer implements Runnable {
		private Warehouse warehouse;

		Consumer(Warehouse warehouse) {
			this.warehouse = warehouse;
		}

		public void run() {
			for (int i = 1; i <= 10; i++) {
				try {
	                Thread.sleep((int) Math.random()*1000);
	            }
	            catch(InterruptedException e) {
	                e.printStackTrace();
	            }
				System.out.println(Thread.currentThread().getId() + "-" + i + " get " + warehouse.get());
			}
		}
	}

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		(new Thread(new Producer(warehouse))).start();
		(new Thread(new Consumer(warehouse))).start();
		(new Thread(new Consumer(warehouse))).start();
	}
}
