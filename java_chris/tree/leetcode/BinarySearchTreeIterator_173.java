package tree.leetcode;

import tree.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {

    class BSTIterator {

        private Stack<TreeNode> stk = new Stack<>();

        public void pushStack(TreeNode node) {
            while (node != null) {
                stk.push(node);
                node = node.left;
            }
        }

        public BSTIterator(TreeNode root) {
            pushStack(root);
        }

        public int next() {
            TreeNode curr = stk.pop();
            pushStack(curr.right);
            return curr.val;
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }
    }
}
