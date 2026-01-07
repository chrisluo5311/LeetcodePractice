package linked_list;
import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static Map<Node, Node> mapToNew = new HashMap<>();
    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        if (mapToNew.containsKey(head)) {
            return mapToNew.get(head);
        }
        Node newNode = new Node(head.val);
        mapToNew.put(head,newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);


        return newNode;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(3);
        head.random = null;
        head.next.next = new Node(3);
        head.next.random = null;
        head.next.next.random = null;
        copyRandomList(head);
    }
}
