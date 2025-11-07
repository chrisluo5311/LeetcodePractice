package tree.leetcode;

import tree.TreeNode;

public class DiameterOfBinaryTree_543 {
    int max_depth = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max_depth;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left_path = dfs(node.left);
        int right_path = dfs(node.right);
        max_depth = Math.max(max_depth, left_path + right_path);
        return 1 + Math.max(left_path, right_path);
    }
}
