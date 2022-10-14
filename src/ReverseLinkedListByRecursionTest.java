/**
 * The recursive version is slightly trickier and the key is to work backwards.
 * Assume that the rest of the list had already been reversed, now how do we reverse the front part?
 * Let's assume the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
 *
 * Assume from node nk+1 to nm had been reversed and we are at node nk.
 * n1 → … → nk-1 → nk → nk+1 ← … ← nm
 *
 * We want nk+1’s next node to point to nk.
 *
 * So,
 * nk.next.next = nk;
 */
public class ReverseLinkedListByRecursionTest {
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){// tail one or head one have been reversed link
            return head;
        }
        ListNode tail = reverseList(head.next);
        /**
         *  * Assume from node nk+1 to nm had been reversed and we are at node nk.
         *  * n1 → … → nk-1 → nk → nk+1 ← … ← nm
         *  *
         *  * We want nk+1’s next node to point to nk.
         *  *
         *  * So,
         *  * nk.next.next = nk;
         */
        head.next = head.next.next; //反轉鏈結
        head.next = null; // 根據上面公式保留反轉空間,
        return tail;
    }
    
    
    public static void main(String args[]) {
        ReverseLinkedListByRecursionTest obj = new ReverseLinkedListByRecursionTest();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode result = obj.reverseList(node1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}