package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        dfs(root,visited);
        return visited;
    }

    public void dfs(TreeNode root, List<Integer> visited){
        if (root == null){
            return;
        }
        visited.add(root.val);
        dfs(root.left,visited);
        dfs(root.right,visited);
    }
}
