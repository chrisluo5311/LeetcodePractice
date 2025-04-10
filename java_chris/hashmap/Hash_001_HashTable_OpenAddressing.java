package hashmap;

import java.util.LinkedList;
import java.util.List;

public class Hash_001_HashTable_OpenAddressing {
    static Integer tombstone = Integer.MIN_VALUE;
    private int space_limit = 10;
    private int space_used = 0;
    private Integer[] nums;
    private Integer[] hash_table;

    public Hash_001_HashTable_OpenAddressing(Integer[] nums) {
        this.nums = nums;
    }

    public void build_hash_table() {
        this.hash_table = new Integer[space_limit];
        for (int i = 0; i < this.nums.length; i++) {
            add(nums[i]);
        }
    }

    public void add(Integer value) {
        double ratio = (double) this.space_used / (double) this.space_limit;
        if (ratio >= 0.7) {
            expand_and_rebuild();
        }

        add_helper(value);
    }

    private void expand_and_rebuild() {
        System.out.println("warning: ratio > 0.7 !");
        // keep current data
        Integer[] hash_table_tmp = new Integer[space_limit];
        for (int i = 0; i < hash_table_tmp.length; i++) {
            hash_table_tmp[i] = this.hash_table[i];
        }

        // initialize new hash table
        space_limit *= 2;
        this.hash_table = new Integer[space_limit];
        this.space_used = 0;

        // rebuild
        for (int i = 0; i < hash_table_tmp.length; i++) {
            Integer value = hash_table_tmp[i];
            if (value == null) continue;
            if (value.equals(tombstone)) continue;

            add_helper(value);
        }
    }

    public void add_helper(Integer value) {
        int index = hash(value);

        int count = 0;
        while (true) {
            if (count == space_limit) break;

            if (this.hash_table[index] == null) {
                this.hash_table[index] = value;
                space_used++;
                break;
            }

            index += 1;
            index %= space_limit;
            count++;
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
        int count = 0;
        while (true) {
            if (count == space_limit) break;

            if (this.hash_table[index] == null) break;
            if (this.hash_table[index] == target_num) {
                System.out.println("Found(hash): " + target_num);
                break;
            }

            index++;
            index %= space_limit;
            count++;
        }
    }

    public void remove(int target_num) {
        int index = hash(target_num);
        int count = 0;
        while (true) {
            if (count == space_limit) break;

            if (this.hash_table[index] == null) break;
            if (this.hash_table[index] == target_num) {
                this.hash_table[index] = tombstone;
                break;
            }

            index++;
            index %= space_limit;
            count++;
        }
    }

    private static Integer[] get_raw_ary() {
//        Integer[] nums = {78,6,80,73,27,61,35,44,29,2};
        Integer[] nums = {78,6,80,73,27,61,35,44,29,2,108, 106, 100, 103, 117, 111, 115, 124, 129, 339};
        return nums;
    }

    public static void main(String[] args) {
        // hash search
        // build hash table
        Integer[] nums = {70,61,81,06,26,47,29};
        Hash_001_HashTable_OpenAddressing hash_table = new Hash_001_HashTable_OpenAddressing(nums);
        hash_table.build_hash_table();

        // search it!
        int target_num = 47;
        hash_table.hash_search(target_num);

        // remove
        target_num = 26;
        hash_table.remove(target_num);
        // search & skip tombstone
        target_num = 47;
        hash_table.hash_search(target_num);

        // maintain 0.7 and clean up tombstones
        hash_table.add(55);

        System.out.println();
    }
}
