package tree;

public class BST_SortedArray {

    private Integer[] nums;
    public BST_SortedArray(Integer[] nums) {
        this.nums = nums;
        // no need to build - cuz we simply change our "view" to the underlying array
    }

    public Integer search(int target) {
        // pick middle-left node as our root every time
        int i_start = 0;
        int i_end = nums.length - 1;
        int i_root = (i_start + i_end)/2;

        if (nums[i_root] == null) return null;
        return search(target, i_start, i_end);
    }

    public Integer search(int target, int i_start, int i_end) {
        if (i_start > i_end) return null;
        int middle = (i_start + i_end) / 2;

        if (this.nums[middle] == target) {
            return this.nums[middle];
        } else if (this.nums[middle] > target) {
            // go left
            return search(target, i_start, middle - 1);
        } else if (this.nums[middle] < target) {
            // go right
            return search(target, middle + 1, i_end);
        }
        return null;
    }

    public Integer search_leftmost(int target) {
        // pick middle-left node as our root every time
        int i_start = 0;
        int i_end = nums.length - 1;
        int i_root = (i_start + i_end)/2;

        if (nums[i_root] == null) return null;
        return search_leftmost(target, i_start, i_end);
    }

    public Integer search_leftmost(int target, int i_start, int i_end) {
        if (i_start > i_end) return null;
        int middle = (i_start + i_end) / 2;

        if (this.nums[middle] == target) {
            Integer tempResult = this.nums[middle];
            Integer node_left = search_leftmost(target, i_start, middle - 1);
            if (node_left != null) {
                tempResult = node_left;
                System.out.println("Found more left node");
            }
            return tempResult;
        } else if (this.nums[middle] > target) {
            // go left
            return search_leftmost(target, i_start, middle - 1);
        } else if (this.nums[middle] < target) {
            // go right
            return search_leftmost(target, middle + 1, i_end);
        }
        return null;
    }

    public Integer search_rightmost(int target) {
        // pick middle-left node as our root every time
        int i_start = 0;
        int i_end = nums.length - 1;
        int i_root = (i_start + i_end)/2;

        if (nums[i_root] == null) return null;
        return search_rightmost(target, i_start, i_end);
    }

    public Integer search_rightmost(int target, int i_start, int i_end) {
        if (i_start > i_end) return null;
        int middle = (i_start + i_end) / 2;

        if (this.nums[middle] == target) {
            Integer tempResult = this.nums[middle];
            Integer node_right = search_rightmost(target, middle+1, i_end);
            if (node_right != null) {
                tempResult = node_right;
                System.out.println("Found more right node");
            }
            return tempResult;
        } else if (this.nums[middle] > target) {
            // go left
            return search_rightmost(target, i_start, middle - 1);
        } else if (this.nums[middle] < target) {
            // go right
            return search_rightmost(target, middle + 1, i_end);
        }
        return null;
    }

}
