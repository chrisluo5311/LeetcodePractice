package linked_list;

public class MiddleOfTheLinkedList {

    //因題目沒有要回傳一個完整的鏈結串列，所以不用保留head
    public static ListNode middleNode(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null){
            head = head.next;
            curr = curr.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode output = middleNode(head);
        System.out.println(output);
    }
}
