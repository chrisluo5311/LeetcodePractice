package HashSet;

import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        // add 新增元素
        // time complexity : O(1)
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
        System.out.println("1. hashSet: " +hashSet);

        // remove 移除元素
        // time complexity : O(1)
        hashSet.remove(2);
        System.out.println("2. hashSet: " +hashSet);

        // contains 判斷元素是否存在
        // time complexity : O(1)
        System.out.println("3. contains 2: " + hashSet.contains(2));
        System.out.println("4. contains 3: " + hashSet.contains(3));

        // size 看含有幾個元素
        System.out.println("5. hashSet's size is : " + hashSet.size());

        // loop 遍歷hashSet
        System.out.print("6. loop through hashSet: ");
        for (int i : hashSet) {
            System.out.print(i+", ");
        }

        // clear 清除全部的元素
        hashSet.clear();
        System.out.println("\n7. clear hashSet: "+hashSet);
    }
}
