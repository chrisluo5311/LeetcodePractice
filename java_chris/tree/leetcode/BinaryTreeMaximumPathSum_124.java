package tree.leetcode;

import tree.TreeNode;

public class BinaryTreeMaximumPathSum_124 {
    static int sub_tree_max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        int res = dfs(root);
        return Math.max(res, sub_tree_max);
    }

    static int dfs(TreeNode root) {
        if (root == null) return -1001;
        int left = dfs(root.left);
        int mid_val = root.val;
        int right = dfs(root.right);

        // calculate sub tree max
        int tempSum = 0;
        if (mid_val >= 0) {
            tempSum += mid_val;
            if (left >= 0) tempSum += left;
            if (right >= 0) tempSum += right;
        } else {
            if (left < 0 && right < 0) {
                tempSum = Math.max(mid_val, Math.max(left, right));
            } else {
                tempSum = mid_val + left + right;
                tempSum = Math.max(tempSum, Math.max(left, right));
            }
        }

        // post order
        if (left < 0 && right < 0) return tempSum;
        sub_tree_max = Math.max(sub_tree_max, tempSum);
        mid_val += Math.max(left, right);
        return mid_val;
    }

    public static void main(String[] args) {

    }
}
