package tree.leetcode;

import tree.TreeNode;

public class BinaryTreeMaximumPathSum_124 {
    int maxNum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxNum;
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftVal = Math.max(0, dfs(node.left));
        int rightVal = Math.max(0, dfs(node.right));

        int tmpVal = node.val + leftVal + rightVal;
        maxNum = Math.max(tmpVal, maxNum);

        return Math.max(leftVal, rightVal) + node.val;
    }
}
