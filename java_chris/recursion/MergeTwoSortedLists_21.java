package recursion;

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        // ListNode l1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        // ListNode l2
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        for (int i = 0 ; i<= 5;i++) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;

        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        head.next = mergeTwoLists(l1,l2);
        return head;
        //time complexity: O(m+n)
        //space complexity: O(m+n)
    }

    public static ListNode mergeTwoLists_Iterative(ListNode l1, ListNode l2) {
        // keep track of the head of the new list, and the tail to add on to
        ListNode head = new ListNode();
        ListNode tail = head;

        // iterate until we reach the end of one list
        while (l1 != null && l2 != null){
            // compare the heads of both list
            if (l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;
        return head.next;

        //time complexity: O(m+n)
        //space complexity: O(1)
    }
}
