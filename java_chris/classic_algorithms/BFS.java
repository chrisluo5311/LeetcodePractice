package classic_algorithms;


import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode == null) continue;
            System.out.print(curNode.val + "\t");
            queue.add(curNode.left);
            queue.add(curNode.right);
        }
    }

    static void bfs_with_integer_arr(Integer[] num) {
        Queue<Integer> queue = new LinkedList<>();
        int root = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Integer curr_index = queue.poll();
            if (curr_index >= num.length) continue;
            if (num[curr_index] == null) continue;

            System.out.print(num[curr_index] + "\t");
            // 用陣列的方式，這個index要記
            int i_left = (curr_index+1)*2 - 1;
            int i_right = (curr_index+1)*2 + 1 - 1;

            queue.add(i_left);
            queue.add(i_right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

//        bfs(root);


        Integer[] nums = new Integer[]{
                5,
                2,6
                ,1,4,null,7
                ,null,null,3,null,null,null,null,null
        };
        bfs_with_integer_arr(nums);
        System.out.println();
    }
}
