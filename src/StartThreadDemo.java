
public class StartThreadDemo extends Thread {

	public void run() {
		for (int i = 0; i < 20; i++) {
			printName();
		}
	}

	private void printName() {
		String name = Thread.currentThread().getName();
		System.out.println("Current thread is " + name);
	}

	public static void main(String args[]) throws InterruptedException {
		StartThreadDemo t = new StartThreadDemo();
		t.setName("test Thread");
		System.out.println(t.isAlive());
		t.start();
		System.out.println(t.isAlive());

		for (int i = 0; i < 2; i++) {
			//t.printName();
			Thread.sleep(1);
			System.out.println(t.isAlive());
		}
	}
}
