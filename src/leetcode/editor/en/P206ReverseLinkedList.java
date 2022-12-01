//Given the head of a singly linked list, reverse the list, and return the rever
//sed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. C
//ould you implement both? 
// Related Topics Linked List Recursion 
// 👍 15032 👎 252

package leetcode.editor.en;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class P206ReverseLinkedList{

    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode result = solution.reverseList(node1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 改變鏈結方向
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while(cur != null){//原本的尾端的下一個
                ListNode tmpNext = cur.next;
                cur.next = pre;
                pre = cur ;
                cur = tmpNext;
            }
            return pre;
        }
    }

}