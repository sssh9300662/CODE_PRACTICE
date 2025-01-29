package opennet;

import java.util.HashSet;
import java.util.Set;

public class CondensList {

	static class SinglyLinkedListNode {
		int data;
		SinglyLinkedListNode next;
	}

	public static void main(String[] args) {
		CondensList obj = new CondensList();
		SinglyLinkedListNode head = new SinglyLinkedListNode();
		SinglyLinkedListNode head1 = new SinglyLinkedListNode();
		SinglyLinkedListNode head2 = new SinglyLinkedListNode();
		SinglyLinkedListNode head3 = new SinglyLinkedListNode();
		head.data = 3;
		head.next = head1;
		head1.data = 4;
		head1.next = head2;
		head2.data = 3;
		head2.next = head3;
		head3.data = 6;
		SinglyLinkedListNode result = obj.condense(head);
		System.out.println(result);
		while(result != null) {
			System.out.println(result.data);
			result = result.next;
		}

	}

	public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		SinglyLinkedListNode current = head;
		SinglyLinkedListNode pre = null;
		Set<Integer> numbers = new HashSet<Integer>();
		
		while(current != null) {
			if(numbers.contains(current.data)) {// duplicate
				pre.next = current.next; // skip current
			}else {
				numbers.add(current.data);
				pre = current;
			}
			current = current.next;
		}
		
		return head;
	}

}
