package tree.leetcode;

import tree.TreeNode;

public class FlattenBinaryTreeToLinkedList_114 {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) return null;

        TreeNode leftNode = dfs(node.left);
        TreeNode rightNode = dfs(node.right);

        node.left = null;
        node.right = leftNode;

        TreeNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        p.right = rightNode;
        return node;
    }
}
