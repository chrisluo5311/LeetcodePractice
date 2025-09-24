package tree.leetcode;

import tree.Node;

import java.util.ArrayList;
import java.util.List;

public class N_aryTreePostorderTraversal_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> visited = new ArrayList<>();
        dfs(root,visited);
        return visited;
    }

    public void dfs(Node root, List<Integer> visited) {
        if (root == null){
            return;
        }
        for (Node child : root.children){
            dfs(child,visited);
        }
        visited.add(root.val);
    }
}
