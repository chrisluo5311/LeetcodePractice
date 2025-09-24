package tree.leetcode;

import tree.TreeNode;

import java.util.*;

//就是把102題的結果反轉
public class BinaryTreeLevelOrderTraversal2_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0 ; i < levelSize ; i++){
                TreeNode currNode = queue.poll();
                temp.add(currNode.val);
                if (currNode.left != null){
                    queue.add(currNode.left);
                }
                if (currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            ans.add(temp);
        }
        Collections.reverse(ans);
        return ans;
    }
}
