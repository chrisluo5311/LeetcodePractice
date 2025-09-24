package tree.heap;

public class MaxHeap {
    private int[] binary_heap_tree;
    private int i_array_end;

    public MaxHeap(int[] ary) {
        this.binary_heap_tree = ary;
        this.i_array_end = ary.length - 1;
    }

    /** BigO = n */
    public void buildHeap(){
        // BFS - from bottom to top
        int i = this.i_array_end;
        while (true) {
            if (i < 0) break;

            shift_down(i);

            i--;
        }
    }

    // BigO = log(n)
    private void shift_down(int i) {

        // pick the bigger child node - binary tree concept, but only pick one node to go
        Integer i_bigger = get_i_bigger_node(i);
        if (i_bigger == null) return;

        if (this.binary_heap_tree[i] < this.binary_heap_tree[i_bigger]) {
            // if smaller, swap value with child node
            swap(i, i_bigger);
            // if smaller, go down and do it again
            shift_down(i_bigger);
        }
    }

    private void swap(int i, Integer iBigger) {
        int tmp = this.binary_heap_tree[i];
        this.binary_heap_tree[i] = this.binary_heap_tree[iBigger];
        this.binary_heap_tree[iBigger] = tmp;
    }

    private Integer get_i_bigger_node(int i) {
        Integer i_bigger = null;

        int i_plus_one = i+1;
        int i_left_plus_one = i_plus_one * 2;
        int i_right_plus_one = i_plus_one * 2 + 1;

        int i_left = i_left_plus_one - 1;
        int i_right = i_right_plus_one - 1;

        if (i_left  <= this.i_array_end && i_right <= this.i_array_end) {
            if (this.binary_heap_tree[i_left] >= this.binary_heap_tree[i_right]) {
                i_bigger = i_left;
            } else {
                i_bigger = i_right;
            }
        } else if (i_left <= this.i_array_end) {
            i_bigger = i_left;
        } else if (i_right <= this.i_array_end) {
            i_bigger = i_right;
        }
        return i_bigger;
    }

    // BigO = log(n)
    public void remove_from_top() {
        // step 01 swap top node with last node
        int i_top = 0;
        swap(i_top, this.binary_heap_tree.length - 1);

        // step 02 pretend the last element removed from the tree
        this.i_array_end--;

        // step 03 shift down the current top node, if necessary
        shift_down(i_top);
    }

    // BigO = log(n)
    public void add_to_bottom(int num_to_add) {
        // step 01: extend your storage if necessary
        if (this.i_array_end + 1 > this.binary_heap_tree.length - 1) {
            extend_storage();
        }

        // step 02: add to the end of the tree
        i_array_end++;
        this.binary_heap_tree[i_array_end] = num_to_add;

        // step 03: shift up, if necessary
        shift_up(i_array_end);
    }

    private void extend_storage() {
        int[] binary_heap_tree_new = new int[this.binary_heap_tree.length * 2];
        for (int i = 0; i < this.binary_heap_tree.length; i++) {
            binary_heap_tree_new[i] = this.binary_heap_tree[i];
        }
        this.binary_heap_tree = binary_heap_tree_new;
    }

    // BigO = log(n)
    private void shift_up(int i) {
        // end condition
        if (i < 0) return;
        if (i == 0) return;

        // get parent index
        int i_plus_one = i + 1;
        int i_parent_plus = i_plus_one / 2;
        int i_parent = i_parent_plus - 1;

        if (this.binary_heap_tree[i_parent] < this.binary_heap_tree[i]) {
            // if bigger, swap value
            swap(i_parent, i);
            // if bigger, go up and do it again
            shift_up(i_parent);
        }
    }
}
