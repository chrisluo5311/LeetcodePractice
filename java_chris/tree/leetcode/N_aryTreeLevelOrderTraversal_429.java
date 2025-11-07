package tree.leetcode;

import tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
public class N_aryTreeLevelOrderTraversal_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int q_size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < q_size; i++) {
                Node currNode = queue.poll();
                tmp.add(currNode.val);
                if (currNode.children.size() > 0) {
                    for (Node nd : currNode.children) {
                        queue.add(nd);
                    }
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
