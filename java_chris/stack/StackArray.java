package stack;

public class StackArray {
    Integer[] ary;
    Integer[] stack;
    Integer i_top = null;

    public StackArray(Integer[] ary) {
        this.ary = ary;
    }

    public void buildStack(){
        this.stack = new Integer[ary.length];
        for (int i = 0; i < ary.length; i++) {
            push(ary[i]);
        }
    }

    private void push(Integer val) {
        if (size() == stack.length) {
            //warning
            expandSpace();
        }

        if (size() == 0) {
            i_top = 0;
        } else {
            i_top++;
        }

        stack[i_top] = val;
    }

    private int size() {
        if (i_top == null) return 0;
        return i_top+1;
    }

    private void expandSpace() {
        Integer[] newStack = new Integer[stack.length * 2];
        for (int i = 0; i < this.stack.length ; i++){
            newStack[i] = stack[i];
        }
        this.stack = newStack;
    }

    private Integer pop(){
        if (i_top == null) return null;

        Integer val = this.stack[i_top];
        this.stack[i_top] = null;

        if (size() == 1) {
            i_top = null;
        } else {
            i_top--;
        }
        return val;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        StackArray stackArray = new StackArray(nums);
        stackArray.buildStack();

        // full
        stackArray.push(6);

        Integer num = stackArray.pop();
        num = stackArray.pop();
        num = stackArray.pop();
        num = stackArray.pop();
        num = stackArray.pop();
        num = stackArray.pop();

        // empty
        num = stackArray.pop();
        System.out.println();
    }

}
