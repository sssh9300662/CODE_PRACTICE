package dynamic.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FibonacciDemo implements Callable<List<Long>> {

	private long number;

	public FibonacciDemo(long number) {
		this.number = number;
	}

	public static void main(String args[]) {
		Callable<List<Long>> fibonacci = new FibonacciDemo(10);
		FutureTask<List<Long>> fibonacciTask = new FutureTask<List<Long>>(fibonacci);

		Thread t = new Thread(fibonacciTask);
		t.start();

		try {
			Thread.sleep(10);

			boolean canceled = fibonacciTask.cancel(false);
			System.out.println("canceled = " + canceled);

			/*if (!fibonacciTask.isCancelled()) {
				List<Long> fib = fibonacciTask.get();
				for (Long f : fib) {
					System.out.print(f + " ");
				}
			}*/

			if (fibonacciTask.isDone()) {
				List<Long> fib = fibonacciTask.get();
				for (Long f : fib) {
					System.out.print(f + " ");
				}
			} else {
				System.out.println("unfinished");
			}
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Long> call() throws Exception {
		List<Long> fib = new ArrayList<Long>();
		fib.add(0L);
		fib.add(1L);

		for (int i = 2; i < number; i++) {
			long value = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
			fib.add(value);
		}
		return fib;
	}

}
