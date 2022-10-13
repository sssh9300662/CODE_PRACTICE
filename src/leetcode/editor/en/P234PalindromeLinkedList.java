//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//
// 
// Example 1:
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2:
//Input: head = [1,2]
//Output: false
// 
// Constraints:
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 

// 
//Follow up: Could you do it in O(n) time and O(1) space?
// Related Topics LinkedList Two Pointers Stack Recursion
// 👍 12012 👎 670

package leetcode.editor.en;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//Java：Palindrome Linked List
public class P234PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        ListNode node4 = new ListNode(2);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println(solution.isPalindrome(node1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode cur = head;
            while(cur != null) {
                stack.push(cur); //先把元素都倒入另一個桶子
                cur = cur.next;
            }
            cur = head; //reset
            /**
             * 兩個集合一起比對
             */
            while(!stack.empty()){
                ListNode node = stack.pop();
                if(node.val != cur.val){//有不符㪋惡
                    return false;
                }
                cur = cur.next;
            }
            return true;
        }
    }

    /**
     * 雙向走訪
     */
    class SolutionRecursivelyCheck {

        private ListNode frontPointer;

        private boolean recursivelyCheck(ListNode currentNode) {
            if (currentNode != null) {//尚未走完list
                if (!recursivelyCheck(currentNode.next)) return false; //是否前一處理有找到對應
                // 找到後進行比對
                if (currentNode.val != frontPointer.val) return false; //前後對應不相等
                // 相等後把前面節點往前
                frontPointer = frontPointer.next;
            }
            return true; // 找到對應或到底部
        }

        public boolean isPalindrome(ListNode head) {
            frontPointer = head; //前面節點找對應的後面節點
            return recursivelyCheck(head);
        }
    }

}