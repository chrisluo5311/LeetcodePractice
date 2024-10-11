package linked_list;

import java.util.Stack;

public class ReorderList_143 {
    public static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        // 4,3,2,1

        curr = head;
        while (curr != null) {
            ListNode popNode = stack.pop();
            ListNode nextNode = curr.next;
            if (nextNode == popNode || popNode.next == nextNode) {
                popNode.next = null;
                break;
            }
            curr.next = popNode;
            popNode.next = nextNode;
            curr = nextNode;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
