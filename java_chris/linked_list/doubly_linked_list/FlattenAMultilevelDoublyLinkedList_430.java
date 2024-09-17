package linked_list.doubly_linked_list;

public class FlattenAMultilevelDoublyLinkedList_430 {

    public static Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        // pseudo head to ensure the `prev` pointer is never none
        Node pseudoHead = new Node(0, null, head, null);

        flattenDFS(pseudoHead, head);

        // detach the pseudo head from the real head
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    public static Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        //　一定要有tempNext，不然如果有child的話，curr.next會直接串連child，就再也找不到原來curr.next
        Node tempNext = curr.next;
        // tail的存在就是child=null時，為curr的一個copy，再用這個tail和tempNext往右邊走
        Node tail = flattenDFS(curr, curr.child);
        // child 要記得移除，不然原本child跟next會指向同一個值，而且child也不用出現在答案裡
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }

    public static void main(String[] args) {
        Node head = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        head.val = 1;
        n2.val = 2;
        n3.val = 3;

        head.prev = null;
        head.next = n2;
        head.child = n3;

        n2.prev = head;
        n2.next = null;
        n2.child = null;

        n3.prev = null;
        n3.next = null;
        n3.child = null;

        Node result = flatten(head);
    }


}
