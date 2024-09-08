package linked_list;

public class DesignLinkedList_707 {

    ListNode head;
    int length;

    public DesignLinkedList_707() {
        this.head = null;
        this.length = 0;
    }

    public int get(int index) {
        if (index >= length || head == null){
            return -1;
        }
        ListNode curr = head;
        while (index > 0){
            curr = curr.next;
            index--;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        if (head == null) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        length++;
    }

    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        if (head == null) {
            head = newTail;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newTail;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        int curr_index = 0;
        if (index < 0 || index > length) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
            length++;
        }else {
            ListNode prev = null;
            ListNode curr = head;
            while (curr_index != index) {
                prev = curr;
                curr = curr.next;
                curr_index++;
            }
            // found
            newNode.next = curr;
            prev.next = newNode;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        int curr_index = 0;
        if (index < 0 || index >= length || head == null){
            return;
        } else if (index == 0){
            head = head.next;
        } else {
            ListNode prev = null;
            ListNode curr = head;
            while (curr_index != index) {
                prev = curr;
                curr = curr.next;
                curr_index++;
            }
            prev.next = curr.next;
            length--;
        }
    }

    public static void main(String[] args) {
        DesignLinkedList_707 linkedList = new DesignLinkedList_707();
        linkedList.addAtHead(2);
        linkedList.addAtIndex(0,1);
        int output = linkedList.get(1);
        System.out.println(output);
    }
}
