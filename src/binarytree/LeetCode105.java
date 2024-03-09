package binarytree;

import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode tree = new LeetCode105().buildTree(preorder, inorder);
    }

    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        for(int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private int rootIndex = 0;

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if(left > right) {
            return null;
        }
        int rootValue = preorder[rootIndex++]; //preOrder從中間元素開始, 所以rootIndex = 根元素的順序
        TreeNode root = new TreeNode(rootValue);
        // inorder 根據root的位置可以分成左右子樹, root的位置的value == preorder第一個元素的value
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1); //先走左子樹
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);
        return root;
    }
}