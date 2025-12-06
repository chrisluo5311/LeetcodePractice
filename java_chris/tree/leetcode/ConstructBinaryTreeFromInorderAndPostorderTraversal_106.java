package tree.leetcode;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    static Map<Integer, Integer> i_track = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length;i++) {
            i_track.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public static TreeNode helper(int[] inorder, int in_start, int in_end, int[] postorder, int p_start, int p_end) {
        if (in_start >= inorder.length || in_end < 0 || p_end < 0) {
            return null;
        }
        int mid = postorder[p_end];
        TreeNode root = new TreeNode(mid);
        int i_mid_index = i_track.get(mid);
        int left_cnt = i_mid_index - in_start;
        root.left = helper(inorder, in_start, i_mid_index-1, postorder, p_start, p_start+left_cnt-1);
        root.right = helper(inorder, i_mid_index+1, in_end, postorder, p_start+left_cnt, p_end-1);
        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = new int[]{9,3,15,20,7};
        int[] postOrder = new int[]{9,15,7,20,3};
        TreeNode ans = buildTree(inOrder, postOrder);
        System.out.println();
    }
}
