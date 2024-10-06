package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 目的：
 * 層序遍歷整棵樹，列印每個節點的路徑權重和
 *
 * */
public class StateTests {
    static class State {
        TreeNode node;
        int depth;

        State (TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    public static void levelOrderTraverse(TreeNode root){
        if (root == null) return;
        Queue<State> q = new LinkedList<>();
        //根節點加權是1
        q.add(new State(root,1));
        while(!q.isEmpty()){
            State state = q.poll();
            System.out.println("depth: " + state.depth + ", node val: " + state.node.val);
            if (state.node.left != null){
                q.add(new State(state.node.left,state.depth+1));
            }
            if (state.node.right != null){
                q.add(new State(state.node.right,state.depth+1));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        levelOrderTraverse(root);
    }
}
