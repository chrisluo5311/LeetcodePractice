package linked_list;

/**
 * @author chris
 */
public class RemoveLinkedListElements_203 {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            if (curr.val == val){
                if (prev == null){
                    //first node
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;// move to next node after deleting
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                        new ListNode(2,
                        new ListNode(6,
                        new ListNode(3,
                        new ListNode(4,
                        new ListNode(5,
                        new ListNode(6)))))));
        System.out.println(removeElements(head,6));
    }
}
