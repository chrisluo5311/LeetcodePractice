package test;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        System.out.println(tree.first());
        System.out.println(tree.last());
        System.out.println(tree.pollFirst());
        System.out.println(tree);
    }
}
