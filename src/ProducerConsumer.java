import java.util.LinkedList;

public class ProducerConsumer {

	private static final int capacity = 3;

	static class Warehouse {
		private LinkedList<Integer> products = new LinkedList<Integer>();

		synchronized void add(Integer product) {
			while (products.size() >= capacity) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Produce " + product);
			products.addLast(product);
			notify();
		}

		synchronized Integer get() {
			while (products.size() <= 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Integer product = products.removeFirst();
			notify();
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
	                Thread.sleep((int) Math.random() * 3000);
	            }
	            catch(InterruptedException e) {
	                e.printStackTrace();
	            }
				warehouse.add(product);
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
	                Thread.sleep((int) Math.random() * 3000);
	            }
	            catch(InterruptedException e) {
	                e.printStackTrace();
	            }
				System.out.println("Get " + i + "-"+ warehouse.get());
			}
		}
	}

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		(new Thread(new Producer(warehouse))).start();
		(new Thread(new Consumer(warehouse))).start();
	}
}
