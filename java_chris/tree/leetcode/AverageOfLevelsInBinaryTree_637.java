package tree.leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            long subTotal = 0;
            for (int i = 0; i < levelSize ; i++){
                TreeNode currNode = queue.poll();
                subTotal += currNode.val;
                if (currNode.left != null){
                    queue.add(currNode.left);
                }
                if (currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            ans.add((double)subTotal/levelSize);
        }
        return ans;
    }
}
