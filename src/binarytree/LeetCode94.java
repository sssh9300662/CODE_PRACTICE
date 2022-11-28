package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null){
            if(cur.left != null){
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            if(cur.right != null){
                result.add(cur.val); //inorder
                cur = cur.right;
                continue;
            }
            // all null means is leaf node
            result.add(cur.val);
            if(stack.isEmpty()){
                break;
            }
            cur = stack.pop();//finish left
            cur.left = null;
        }
        return result;
    }

    // recursion way
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res); // 走left子樹
            res.add(root.val);//左邊走完,inorder
            helper(root.right, res); //再走右子樹
        }
    }

    public static void main(String args[]){
        LeetCode94 lc = new LeetCode94();
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);
        System.out.println(lc.inorderTraversal(root));
    }
}
