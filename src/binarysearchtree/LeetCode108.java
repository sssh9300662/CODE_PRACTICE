package binarysearchtree;

import binarytree.LeetCode94;

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

public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {// This solution is cont complete
        // since hard to tackle even number of elements
        if(nums.length == 1){
            return new TreeNode(nums[0], null, null);
        }
        int balance = nums.length/2;
        if(nums.length > 2){
            balance = balance +1;
        }
        int curLevel = 1;
        TreeNode pre = null;
        TreeNode root = null;

        for(int num : nums){
            TreeNode cur = new TreeNode(num);
            if(curLevel < balance){
                if(pre != null){
                    cur.left = pre;
                }
                pre = cur;
                curLevel ++;
            }else{
                root = cur;
                if(pre != null) {//turn to right
                    cur.left = pre;
                    curLevel =1;
                    pre = null;
                }else{
                    pre = cur;
                }
            }
        }
        if(root.left == null){
            root.left = pre;
        }else{
            root.right = pre;
        }
        return root;
    }

    private int[] nums;

    public TreeNode sortedArrayToBST2(int[] nums) {// separate elements into two part (tree)
        if(nums.length == 1){
            return new TreeNode(nums[0], null, null);
        }
        nums = nums;
        return helper(0, nums.length-1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        // always choose left middle node as a root
        int p = (left + right) / 2;
        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public static void main(String args[]){
        LeetCode108 lc = new LeetCode108();
        TreeNode result = lc.sortedArrayToBST2(new int[]{0});
    }
}
