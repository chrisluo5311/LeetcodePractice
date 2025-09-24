package tree.leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree_501 {
    Integer prev = null;
    Integer count = 0;
    Integer max = 0;
    List<Integer> temp = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        treeSortHelper(root);
        return convertToIntArr();
    }

    public int[] convertToIntArr() {
        int[] result = new int[this.temp.size()];
        int i = 0;
        for (Integer t : temp) {
            result[i++] = t;
        }
        return result;
    }

    public void treeSortHelper(TreeNode node) {
        if (node.left != null) treeSortHelper(node.left);

        // inorder check (smallest -> biggest)
        if (this.prev == null) {
            // First node
            this.prev = node.val;
            this.count = 1;
        } else if (this.prev != node.val) {
            // new bigger node
            this.prev = node.val;
            this.count = 1;
        } else {
            // same with prev
            this.count += 1;
        }

        // count vs max
        if (this.count > this.max) {
            this.max = this.count;
            temp.clear();
            temp.add(node.val);
        } else if (this.count == this.max) {
            // add another node
            temp.add(node.val);
        } else if (this.count < this.max) {
            // do nothing
        }

        if (node.right != null) treeSortHelper(node.right);
    }

    public static void main(String[] args) {
        // [1,null, 8, 6, 10, 4, 7, 10 , 12, 4, 5, 7]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(12);
        root.right.left.left.left = new TreeNode(4);
        root.right.left.left.right = new TreeNode(5);
        root.right.left.right.left = new TreeNode(7);

        FindModeInBinarySearchTree_501 test = new FindModeInBinarySearchTree_501();
        int[] result = test.findMode(root);
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }
}
