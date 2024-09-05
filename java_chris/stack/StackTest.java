package stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stackExample = new Stack<>();
        //push item into stack
        stackExample.push(1);
        stackExample.push(2);
        stackExample.push(3);
        //pop the top item
        int firstPop = stackExample.pop();
        System.out.println("first pop = " + firstPop);
        System.out.println(stackExample);
        //take a look at the top item but not removing it
        int currTop = stackExample.peek();
        System.out.println("currTop = " + currTop);
        // empty(): check if stack is empty. Return true if is empty, false otherwise
        System.out.println("Is stackExample empty: "+stackExample.empty());
        // search(Object o): search for o and return its position
        int indexOfElement = stackExample.search(2);
        System.out.println("index Of Element 2 is: " + indexOfElement);
    }
}
