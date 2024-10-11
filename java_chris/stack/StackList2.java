package stack;

public class StackList2 {
    static class Node{
        Integer val;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }

    Integer[] ary;
    Node node_top;

    public StackList2(Integer[] ary) {
        this.ary = ary;
    }

    public void buildStack(){
        for (int i = 0; i < ary.length; i++) {
            push(ary[i]);
        }
    }

    private void push(Integer val) {
        if (node_top == null) {
            node_top = new Node(val);
        } else {
            Node cur = new Node(val);
            cur.next = node_top;
            node_top = cur;
        }
    }

    public Integer pop() {
        if (node_top == null) {
            return null;
        }

        Node node = node_top;
        node_top = node.next;
        return node.val;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        StackList2 stackList = new StackList2(nums);
        stackList.buildStack();

        // full
        stackList.push(6);

        Integer num = stackList.pop();
        num = stackList.pop();
        num = stackList.pop();
        num = stackList.pop();
        num = stackList.pop();
        num = stackList.pop();

        // empty
        num = stackList.pop();

        // push + pop
        stackList.push(11);
        stackList.push(12);
        stackList.push(13);
        num = stackList.pop();
        num = stackList.pop();
        stackList.push(14);
        num = stackList.pop();

        System.out.println();
    }
}
