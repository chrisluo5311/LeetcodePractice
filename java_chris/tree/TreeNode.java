package tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 前序走訪的順序是「中左右」
    public void preOrder(){
        System.out.print(val+", ");
        if(left != null) left.preOrder();
        if(right != null) right.preOrder();
    }

    // 中序走訪的順序是「左中右
    public void inOrder(){
        if(left != null) left.inOrder();
        System.out.print(val+", ");
        if(right != null) right.inOrder();
    }

    // 後序走訪的順序是「左右中」
    public void postOrder(){
        if(left != null) left.postOrder();
        if(right != null) right.postOrder();
        System.out.print(val+", ");
    }
}
