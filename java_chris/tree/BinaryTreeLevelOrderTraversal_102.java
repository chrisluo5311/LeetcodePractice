package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int levelSize = queue.size();
            for (int i=0;i<levelSize;i++){
                TreeNode currNode = queue.poll();
                temp.add(currNode.val);
                if (currNode.left != null){
                    queue.add(currNode.left);
                }
                if (currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            if(temp.size() > 0){
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
    }
}
