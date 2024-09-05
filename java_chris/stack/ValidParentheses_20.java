package stack;

import java.util.Stack;

public class ValidParentheses_20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character i : s.toCharArray()){
            if (i == '(' || i == '{' || i == '[') {
                stack.push(i);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                if (i == ')' && stack.peek() == '('){
                    stack.pop();
                } else if (i == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (i == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "()[]{}";
        System.out.println(isValid(test1));
    }
}
