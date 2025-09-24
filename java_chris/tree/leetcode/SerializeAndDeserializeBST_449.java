package tree.leetcode;

import tree.TreeNode;

import java.util.LinkedList;

public class SerializeAndDeserializeBST_449 {

    String SEP = ",";
    String NULL_SEP = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 2,1,#,#,3,#,#,
        StringBuilder sb = new StringBuilder();
        inOrderSerialize(sb, root);
        return sb.toString();
    }

    public void inOrderSerialize(StringBuilder sb, TreeNode root){
        if (root == null) {
            sb.append(NULL_SEP).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        inOrderSerialize(sb, root.left);
        inOrderSerialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s: data.split(SEP)) {
            nodes.add(s);
        }
        return inOrderDeseialize(nodes);
    }

    public TreeNode inOrderDeseialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        String middle = nodes.removeFirst();
        if (middle.equals(NULL_SEP)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(middle));

        root.left = inOrderDeseialize(nodes);
        root.right = inOrderDeseialize(nodes);

        return root;
    }
}
