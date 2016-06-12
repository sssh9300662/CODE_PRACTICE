
public class LinkedListTest {

	static class LinkedList<E> {
		class Node<E> {
			E item;
			Node<E> prev, next;
		}
		
		Node<E> first, last;
		int size = 0;
		
		void reverse() {}
	}
	
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		
	}

}
