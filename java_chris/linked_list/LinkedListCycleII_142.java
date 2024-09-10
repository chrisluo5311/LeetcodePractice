package linked_list;

public class LinkedListCycleII_142 {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }


        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        int index = 0;
        while (head != slow){
            head = head.next;
            index++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode output = detectCycle(head);
        System.out.println("hi");
    }
}
