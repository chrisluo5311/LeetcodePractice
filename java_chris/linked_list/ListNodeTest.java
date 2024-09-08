package linked_list;


public class ListNodeTest {

    // 遍歷 ListNode
    public static void traverse(ListNode current_node) {
        while (current_node != null) {
            System.out.println(current_node.val);
            current_node = current_node.next;
        }
    }

    //查找節資料
    public static void findNodes(ListNode current_node, int target) {
        while (current_node != null) {
            if (current_node.val == target) {
                System.out.println("找到");
                break;
            }
            current_node = current_node.next;
        }
    }

    public static void addNewNodes(ListNode current_node, int position, ListNode newNode) {
        while (current_node != null) {
            if (current_node.val == position ){
                newNode.next = current_node.next;
                current_node.next = newNode;
                break;
            }
            current_node = current_node.next;
        }
    }

    public static void deleteNodes(ListNode head, ListNode current_node, int deleteVal) {
        System.out.println("刪除新資料");
        ListNode previous = null;
        while (current_node != null) {
            if (current_node.val == 2) {
                if (previous != null) {
                    previous.next = current_node.next;
                } else {
                    //previous還是null
                    //代表停留在首節點 => head 直接移到下一個節點
                    head = current_node.next;
                }
                break;
            }
            previous = current_node;
            current_node = current_node.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(node1);
        ListNode head = node1;
        ListNode current_node = head;

        System.out.println("======================");

        // 遍歷 ListNode
//        traverse(head);

        //查找節資料
//        findNodes(current_node,3);

        //插入新資料
//        ListNode newNode = new ListNode(1000);
//        int position = 2;
//        addNewNodes(current_node, position, newNode);
//        System.out.println(node1);

        //刪除新資料
        deleteNodes(head,current_node,2);
        System.out.println(node1);
    }
}
