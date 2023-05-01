package lists;

/**
 * @author chris
 */
public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }

        // [1,2,6,3,4,5,6]
        ListNode currentNode = head;
        while(currentNode!=null && currentNode.next != null){
            // 直接使用currentNode.next.val因為第一個已經在第一行檢查過
            if (currentNode.next.val == val){
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(6,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6)))))));
        System.out.println(removeElements(head,6).toString());
    }
}
