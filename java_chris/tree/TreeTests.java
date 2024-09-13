package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class TreeTests {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

//        root.preOrder();
        // BFS
        BFS(root);

        // DFS
//        DFS(root);
    }

    public static void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> visited = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            TreeNode firstNode = queue.poll();
            visited.add(firstNode.val);
            if (firstNode.left != null) {
                queue.add(firstNode.left);
            }
            if (firstNode.right != null) {
                queue.add(firstNode.right);
            }
        }
        Stream.of(visited).forEach(System.out::println);
    }

    public static void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        DFS(root.left);
        DFS(root.right);
    }
}
