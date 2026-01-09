package tree;

/**
 * This question is the same as 1123: <a href="https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/">...</a>
 * */
public class SmallestSubtreeWithAllTheDeepestNodes_865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);

        Result left = dfs(node.left);
        Result right = dfs(node.right);
        if (left.dist < right.dist) return new Result(right.node, right.dist+1);
        if (left.dist > right.dist) return new Result(left.node, left.dist+1);
        // equal depth => return parent
        return new Result(node, left.dist+1);
    }

    public static void main(String[] args) {
        SmallestSubtreeWithAllTheDeepestNodes_865 smallSum = new SmallestSubtreeWithAllTheDeepestNodes_865();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode res = smallSum.subtreeWithAllDeepest(root);
        System.out.println(res.val); // 2
    }
}

class Result {
    TreeNode node;
    int dist;
    public Result(TreeNode node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
