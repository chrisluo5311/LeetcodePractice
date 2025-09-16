package tree;

public class BST {
    private int[] nums;
    private TreeNode root;
    public static void main(String[] args) {
//        int[] nums = new int[]{5,2,6,1,4,7,3};
        int[] nums = new int[]{5,6,7,2,1,6,2};
//        BST bst = new BST(nums);
//        bst.buildTree();
//        System.out.println();

        // tree sort ascending or descending
        System.out.print("\ntree sort (dfs left): ");
        BST.tree_sort_ascending(nums);
        System.out.print("\ntree sort (dfs right): ");
        BST.tree_sort_descending(nums);

        // delete
        // x x
//        bst.delete(7);
//        System.out.println();

        // x right
//        bst.delete(6);
//        System.out.println();

        // left x
//        bst.delete(4);
//        System.out.println();

        // left right
//        bst.delete(2);
//        System.out.println();

        // delete root
//        bst.delete(5);
//        System.out.println();

        // search
//        TreeNode node_found = null;
//        node_found = bst.search(2);
//        System.out.println("Found: " + (node_found == null ? "NOT FOUND" : node_found.val));
//        node_found = bst.search(7);
//        System.out.println("Found: " + (node_found == null ? "NOT FOUND" : node_found.val));
//        node_found = bst.search(10);
//        System.out.println("Found: " + (node_found == null ? "NOT FOUND" : node_found.val));


        /** in-order traversal = n * (getMin + delete) **/
//        while (true) {
//            TreeNode min = bst.getMin();
//            if (min == null) break;
//            System.out.print(min.val + "\t");
//            bst.delete(min.val);
//        }

        /** in-order traversal = n * (getMax + delete) **/
//        while (true) {
//            TreeNode max = bst.getMax();
//            if (max == null) break;
//            System.out.print(max.val + "\t");
//            bst.delete(max.val);
//        }
    }

    public BST(int[] nums) {
        this.nums = nums;
    }

    public void buildTree() {
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public void add(int val) {
        TreeNode root_after_add = add(this.root, val);
        if (this.root != root_after_add){
            this.root = root_after_add;
        }
    }

    public static TreeNode add(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val == node.val) {
            // x
            if (node.left == null) {
                node.left = new TreeNode(val);
            }
            // left
            if (node.left != null) {
                TreeNode node_new_left = new TreeNode(val);
                node_new_left.left = node.left;
                node.left = node_new_left;
            }

        } else if (val < node.val) {
            TreeNode child_node = add(node.left, val);
            if (node.left != child_node) {
                node.left = child_node;
            }
        } else {
            TreeNode child_node = add(node.right, val);
            if (node.right != child_node) {
                node.right = child_node;
            }
        }
        return node;
    }

    public void delete(int val) {
        if (this.root == null) return;
        TreeNode root_after_delete = delete(this.root, val);
        if (this.root != root_after_delete) {
            this.root = root_after_delete;
        }
    }

    private TreeNode delete(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        TreeNode node_final = node;
        if (val == node.val) {
            // 4 situations when val equals node.val
            // x x
            if (node.left == null && node.right == null) {
                node_final = null;
            }
            // left x
            else if (node.left != null && node.right == null) {
                node_final = node.left;
            }
            // x right
            else if (node.left == null && node.right != null) {
                node_final = node.right;
            }
            // left right
            else {
                // change the current node with the min node of the right tree
                TreeNode right_min = getMin(node.right);
                swap_node(node, right_min);
                //第二戰場
                TreeNode child_node = delete(node.right, val);
                if (node.right != child_node) {
                    node.right = child_node;
                }

            }
        } else if (val < node.val) {
            TreeNode node_child = delete(node.left, val);
            if (node.left != node_child) {
                node.left = node_child;
            }
        } else {
            TreeNode node_child = delete(node.right, val);
            if (node.right != node_child) {
                node.right = node_child;
            }
        }

        return node_final;
    }

    private void swap_node(TreeNode node, TreeNode rightMin) {
        int tmp = node.val;
        node.val = rightMin.val;
        rightMin.val = tmp;
    }

    public TreeNode getMin() {
        return getMin(this.root);
    }

    private TreeNode getMin(TreeNode right) {
        if (right == null) return null;
        TreeNode node = right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode getMax() {
        return getMax(this.root);
    }

    private TreeNode getMax(TreeNode left) {
        if (left == null) return null;
        TreeNode node = left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode search(int val) {
        if (this.root == null) return null;
        return search(this.root, val);
    }

    private TreeNode search(TreeNode node, int val) {
        if (node == null) return null;
        if (val == node.val) {
            return node;
        } else if (val < node.val) {
            return search(node.left, val);
        } else {
            return search(node.right, val);
        }
    }

    /** tree sort (DFS left) */
    public static void tree_sort_ascending(int[] nums) {
        BST bst = new BST(nums);
        bst.buildTree();
        bst.root.inOrder();
    }

    /** tree sort (DFS right) */
    public static void tree_sort_descending(int[] nums) {
        BST bst = new BST(nums);
        bst.buildTree();
        bst.root.inOrderRight();
    }
}
