package recursion;

import java.util.Stack;

public class Hanoi {
    static Stack<Integer> pillar_A = new Stack<>();
    static Stack<Integer> pillar_B = new Stack<>();
    static Stack<Integer> pillar_C = new Stack<>();

    public static void main(String[] args) {
        /* initialization */
        pillar_A.push(5);
        pillar_A.push(4);
        pillar_A.push(3);
        pillar_A.push(2);
        pillar_A.push(1);

        int layer = pillar_A.size();
        /* Divide & Conquer */
        hanoi(layer, pillar_A, pillar_B, pillar_C);
        System.out.println();
    }

    private static void hanoi(int layer, Stack<Integer> pillar_from,
                                Stack<Integer> pillar_mid,
                                Stack<Integer> pillar_to) {
        if (layer == 0) return;

        // step1: move the above plate to the pillar mid to clear the room for the plate below
        hanoi(layer - 1, pillar_from, pillar_to, pillar_mid);

        // step2: main target
        Integer target = pillar_from.pop();
        pillar_to.push(target);

        // step3: move the original pillar back to pillar_to
        hanoi(layer -1, pillar_mid,pillar_from, pillar_to);

    }
}
