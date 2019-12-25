public class ReverseLinkedListTest {
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    
    
    public static void main(String args[]) {
        ReverseLinkedListTest obj = new ReverseLinkedListTest();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        ListNode result = obj.reverseList(node1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}