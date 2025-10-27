package tree;

/**
 * Implementation of AVL Tree
 *
 * */
public class BST_AVL {
    private int[] nums;
    private TreeNode root;

    /** AVL Tree */

    private TreeNode balance(TreeNode node) {
        int depth_gap = get_depth_gap(node);
        // still balance -> no need to balance
        if (Math.abs(depth_gap) <= 1) {
            return node;
        }

        if (depth_gap > 1) {
            // 左邊深 -> go left
            TreeNode node_left_result = balance(node.left);
            if (node_left_result != node.left) {
                node.left = node_left_result;
            }
        } else if (depth_gap < -1) {
            // 右邊深 -> go right
            TreeNode node_right_result = balance(node.right);
            if (node_right_result != node.right) {
                node.right = node_right_result;
            }
        }

        depth_gap = get_depth_gap(node);
        if (Math.abs(depth_gap) <= 1) {
            return node;
        }

        // main logic
        if (depth_gap > 1) {
            // 左邊較深
            // check next layer
            int depth_gap_nextlayer = get_depth_gap(node.left);
            if (depth_gap_nextlayer >= 0) {
                System.out.println("Left Left");
            } else if (depth_gap_nextlayer < 0) {
                System.out.println("Left Right");
                TreeNode node_left_result = rotate_left(node.left);
                if (node_left_result != node.left) {
                    node.left = node_left_result;
                }
            }
            // right turn
            TreeNode result = rotate_right(node);
            if (result != node) {
                return result;
            }
        } else if (depth_gap < -1) {
            // 右邊較深
            // check next layer
            int depth_gap_nextlayer = get_depth_gap(node.right);
            if (depth_gap_nextlayer <= 0) {
                System.out.println("Right Right");
            } else if (depth_gap_nextlayer > 0) {
                System.out.println("Right Left");
                TreeNode node_right_result = rotate_right(node.right);
                if (node_right_result != node.right) {
                    node.right = node_right_result;
                }
            }

            // left turn
            TreeNode result = rotate_left(node);
            if (result != node) {
                return result;
            }
        }
        return node;
    }


    private TreeNode rotate_left(TreeNode node) {
        TreeNode old_root = node;
        TreeNode new_root = node.right;
        TreeNode sub_tree = node.right.left;

        old_root.right = sub_tree;
        new_root.left = old_root;

        return new_root;
    }

    public TreeNode rotate_right(TreeNode node) {
        TreeNode old_root = node;
        TreeNode new_root = node.left;
        TreeNode sub_tree = node.left.right;

        old_root.left = sub_tree;
        new_root.right = old_root;

        return new_root;
    }

    private int get_depth_gap(TreeNode node) {
        int depth_gap = get_depth(node.left) - get_depth(node.right);
        // > 0 : 左邊深
        // == 0 : 一樣深
        // < 0 : 右邊深
        return depth_gap;
    }

    private int get_depth(TreeNode node) {
        if (node == null) return 0;
        int depth = 1 + Math.max(get_depth(node.left), get_depth(node.right));
        return depth;
    }

    /** BST */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(){}
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public BST_AVL(int[] nums) {
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

        TreeNode root_after_balance = balance(this.root);
        if (this.root != root_after_balance) {
            this.root = root_after_balance;
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

    public static void main(String[] args) {
        /** add **/
//        int[] nums = {5,4,3}; // Left-Left
//        int[] nums = {5,3,4}; // Left-Right
//        int[] nums = {3,4,5}; // Right-Right
//        int[] nums = {3,5,4}; // Right-Left

        // test it without balance logic -> test with balance logic
        int[] nums = {100,80,60,40,20,70};

        BST_AVL bst_avl = new BST_AVL(nums);
        bst_avl.buildTree();
        System.out.println();
    }
}
