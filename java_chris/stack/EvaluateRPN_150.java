package stack;

import java.util.Stack;

public class EvaluateRPN_150 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if (!token.equals("+") && !token.equals("-") &&
                    !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer b = stack.pop();
                Integer a = stack.pop();
                if (token.equals("+")) {
                    stack.push(a+b);
                } else if (token.equals("-")) {
                    stack.push(a-b);
                } else if (token.equals("*")) {
                    stack.push(a*b);
                } else {
                    stack.push(a/b);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
