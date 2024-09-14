package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return 0;
        }
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i<levelSize;i++){
                TreeNode curr = queue.poll();
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
            count++;
        }
        return count;
    }
}
