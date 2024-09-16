package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        insert(root, 5);
        insert(root, 9);
        insert(root, 3);
        insert(root, 6);
        insert(root, 8);
        insert(root, 10);

        //搜尋 O(logN)
        System.out.print("BST搜尋6：");
        search(root, 6);

        //DFS走訪
        System.out.print("DFS「前序」走訪：");
        root.preOrder();//前序
        System.out.print("\nDFS「中序」走訪：");
        root.inOrder();//中序, 讓二元搜尋數有排序
        System.out.print("\nDFS「後序」走訪：");
        root.postOrder();

        //BFS
        System.out.print("\nBFS：");
        List<Integer> result = BFS(root);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    public static void insert(TreeNode root, int data) {
        if (root.val == 0){
            root.val = data;
        } else if (data < root.val) {
            //根節點左邊
            if  (root.left == null) {
                root.left = new TreeNode(data);
            } else {
                insert(root.left, data);
            }
        } else {
            //根節點右邊
            if  (root.right == null) {
                root.right = new TreeNode(data);
            } else {
                insert(root.right, data);
            }
        }
    }

    public static int search(TreeNode root, int target) {
        if (root.val == target) {
            System.out.println("Found "+target+"!!!");
            return root.val;
        } else if (target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static List<Integer> BFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> visited = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            visited.add(currNode.val);
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
        return visited;
    }
}
