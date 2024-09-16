package linked_list.doubly_linked_list;

public class DoublyListNodeTest {

    public static DoublyListNode createDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode cur = head;
        // for 循环迭代创建双链表
        for (int i = 1; i < arr.length; i++) {
            DoublyListNode newNode = new DoublyListNode(arr[i]);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static DoublyListNode insertMiddle(DoublyListNode head, int target, int data) {
        DoublyListNode newNode = new DoublyListNode(data);
        DoublyListNode curr = head;
        while (curr != null) {
            if (curr.val == target) {
                // newNode first
                newNode.next = curr.next;
                newNode.prev = curr;
                // nextNode & currNode
                curr.next.prev = newNode;
                curr.next = newNode;
            }
            curr = curr.next;
        }
        return head;
    }

    public static DoublyListNode deleteMiddle(DoublyListNode head, int target) {
        DoublyListNode curr = head;
        DoublyListNode prev = head;
        while (curr != null) {
            if (curr.val == target) {
                prev.next = curr.next;
                curr.next.prev = prev;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static DoublyListNode deleteLastOne(DoublyListNode head) {
        DoublyListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        DoublyListNode head = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5});

        // insert data in the middle of the doubly linked list
        System.out.println("insert data:");
        int data = 100;
        DoublyListNode result = insertMiddle(head, 3, data);
        while (result != null) {
            System.out.print(result.val+", ");
            result = result.next;
        }

        System.out.println("\ndelete data:");
        // delete data in the middle of the doubly linked list
        int target = 100;
        DoublyListNode afterDeletionResult = deleteMiddle(head, target);
        while (afterDeletionResult != null) {
            System.out.print(afterDeletionResult.val+", ");
            afterDeletionResult = afterDeletionResult.next;
        }

        // delete last one
        System.out.println("\ndelete last one:");
        DoublyListNode afterDeletingLastOne = deleteLastOne(head);
        while (afterDeletingLastOne != null) {
            System.out.print(afterDeletingLastOne.val+", ");
            afterDeletingLastOne = afterDeletingLastOne.next;
        }
    }
}
