package tree.leetcode;

import tree.TreeNode;

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        dfs(root.left);
        dfs(root.right);
    }
}
