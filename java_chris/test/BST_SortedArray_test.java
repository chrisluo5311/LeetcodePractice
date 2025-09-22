package test;

import tree.BST_SortedArray;

public class BST_SortedArray_test {

    public static void main(String[] args) {
        Integer[] nums = {0, 11, 22, 44, 44, 44};
        BST_SortedArray bst = new BST_SortedArray(nums);
        Integer result = bst.search(44);
        System.out.println("Found: " + (result == null ? "NOT FOUND" : result));
        Integer left_result = bst.search_leftmost(44);
        System.out.println("Found: " + (left_result == null ? "NOT FOUND" : left_result));
        Integer right_result = bst.search_rightmost(44);
        System.out.println("Found: " + (right_result == null ? "NOT FOUND" : right_result));
    }

}
