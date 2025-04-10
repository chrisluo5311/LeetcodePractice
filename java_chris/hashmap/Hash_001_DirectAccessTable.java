package hashmap;

public class Hash_001_DirectAccessTable {
    private Integer[] nums;
    private Integer[] direct_access_table;

    public Hash_001_DirectAccessTable(Integer[] nums) {
        this.nums = nums;
    }

    public void build_direct_access_table() {
        int num_max = get_max(this.nums);
        this.direct_access_table = new Integer[num_max + 1];
        for (int i = 0; i < this.nums.length; i++) {
            add(this.nums[i]);
        }
    }

    private void add(Integer value) {
        int index = value;
        this.direct_access_table[index] = value;
    }

    private int get_max(Integer[] nums) {
        int num_max = -1;
        for (Integer num : nums) {
            if (num > num_max) {
                num_max = num;
            }
        }
        return num_max;
    }

    public void search(int target_value) {
        int index = target_value;
        if (this.direct_access_table[index] == target_value) {
            System.out.println("Found(direct): " + target_value);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{78, 6, 80, 73, 27, 61, 35, 44, 29, 2};
        Hash_001_DirectAccessTable table = new Hash_001_DirectAccessTable(nums);
        table.build_direct_access_table();

        table.search(78);
        System.out.println();
    }
}
