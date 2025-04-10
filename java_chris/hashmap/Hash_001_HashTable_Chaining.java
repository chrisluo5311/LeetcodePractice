package hashmap;

import java.util.LinkedList;
import java.util.List;

public class Hash_001_HashTable_Chaining {

    static class Chaining {
        public List<Integer> list = new LinkedList<>();
    }

    private int space_limit = 10;
    private Integer[] nums;
    private Chaining[] hash_table;

    public Hash_001_HashTable_Chaining(Integer[] nums) {
        this.nums = nums;
    }

    public void build_hash_table() {
        this.hash_table = new Chaining[space_limit];
        for (int i = 0; i < this.nums.length; i++) {
            add(nums[i]);
        }
    }

    public void add(Integer value) {
        int index = hash(value);
        // get chaining list
        if (this.hash_table[index] == null) {
            this.hash_table[index] = new Chaining();
        }
        Chaining curr_chain = this.hash_table[index];

        // add as long as not existing yet
        if (!curr_chain.list.contains(value)) {
            curr_chain.list.add(value);
        }

    }

    private int hash(Integer value) {
        return mod(value, space_limit);
    }

    private int mod(int n, int m) {
        return (n % m + m) % m;
    }

    public void hash_search(int target_num) {
        int index = hash(target_num);
        if (this.hash_table[index] != null) {
            Chaining curr_chain = this.hash_table[index];
            if (curr_chain.list.contains(target_num)) {
                System.out.println("Found(hash): " + target_num);
            }
        } else {
            System.out.println("NO SUCH Hash Table");
        }
    }

    public void remove(int target_num) {
        int index = hash(target_num);
        if (this.hash_table[index] != null) {
            Chaining curr_chain = this.hash_table[index];
            if (curr_chain.list.contains(target_num)) {
                int target_index = curr_chain.list.indexOf(target_num);
                curr_chain.list.remove(target_index);
            }
        }
    }

    private static Integer[] get_raw_ary() {
//        Integer[] nums = {78,6,80,73,27,61,35,44,29,2};
        Integer[] nums = {78,6,80,73,27,61,35,44,29,2,108, 106, 100, 103, 117, 111, 115, 124, 129, 339};
        return nums;
    }

    public static void main(String[] args) {
        int target_num = 29;
        Integer[] nums = get_raw_ary();
        Hash_001_HashTable_Chaining hash_table = new Hash_001_HashTable_Chaining(nums);
        hash_table.build_hash_table();
        hash_table.hash_search(target_num);

        // remove
        target_num = 339;
        hash_table.remove(target_num);
        hash_table.hash_search(target_num);

        System.out.println();
    }
}
