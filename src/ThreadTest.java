
public class ThreadTest {
	
	public static void main(String args[]){
		/*Object obj = new Object();
		synchronized(Thread.currentThread()){
			try {
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.notify();
		}*/
		String a = new String("ABCDE");
		String s = a.substring(0,3);
		System.out.println(a);
		System.out.println(s);
	}

}
