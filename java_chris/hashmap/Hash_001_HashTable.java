package hashmap;

public class Hash_001_HashTable {
    private int space_limit = 10;
    private Integer[] nums;
    private int[] hash_table;

    public Hash_001_HashTable(Integer[] nums) {
        this.nums = nums;
    }

    public void build_hash_table() {
        this.hash_table = new int[space_limit];
        for (int i = 0; i < this.nums.length; i++) {
            add(nums[i]);
        }
    }

    public void add(Integer value) {
        int index = hash(value);
        this.hash_table[index] = value;
    }

    private int hash(Integer value) {
        return mod(value, space_limit);
    }

    private int mod(int n, int m) {
        return (n % m + m) % m;
    }

    public void hash_search(int target_num) {
        int index = hash(target_num);
        if (this.hash_table[index] == target_num) {
            System.out.println("found(hash): " + target_num);
        }
    }

    private static Integer[] get_raw_ary() {
        Integer[] nums = {78,6,80,73,27,61,35,44,29,2};
        return nums;
    }

    public static void main(String[] args) {
        int target_num = 29;
        Integer[] nums = get_raw_ary();
        Hash_001_HashTable hash_table = new Hash_001_HashTable(nums);
        hash_table.build_hash_table();
        hash_table.hash_search(target_num);
        System.out.println();
    }
}
