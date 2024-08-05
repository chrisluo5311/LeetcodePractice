package recursion;

public class SearchInABinarySearchTree_700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode result = searchBST(root,2);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return (val > root.val) ? searchBST(root.right,val) : searchBST(root.left,val);
    }
}
