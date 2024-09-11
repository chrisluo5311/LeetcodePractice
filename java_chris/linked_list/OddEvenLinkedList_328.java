package linked_list;

public class OddEvenLinkedList_328 {

    //my answer
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode evenStart = dummy;
        ListNode prev = head;
        ListNode curr = head;
        int index = 1;
        while (curr.next != null) {
            if (index % 2 == 0){
                dummy.next = curr;
                prev.next = curr.next;
                dummy = dummy.next;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        dummy.next = (index % 2 == 0) ? curr : null;
        // prev -> evenStart.next
        if (prev != null) {
            if (index % 2 == 0){
                prev.next = evenStart.next;
            } else {
                curr.next = evenStart.next;
            }
        }
        return head;
    }

    public static ListNode oddEvenList_officialAns(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);

        // 1 > 3

//        ListNode result = oddEvenList(head);
        ListNode result = oddEvenList_officialAns(head);
        System.out.println(result);
    }

}
