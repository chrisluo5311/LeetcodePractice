package linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(ListNode l1, ListNode l2){
                Integer l1_val = l1.val;
                Integer l2_val = l2.val;
                return l1_val.compareTo(l2_val);
            }
        });
        for (ListNode node : lists) {
            while (node != null) {
                int curVal = node.val;
                node = node.next;
                ListNode newNode = new ListNode(curVal);
                pq.add(newNode);
            }
        }
        for (int i=0;i<lists.length;i++){
            ListNode temp = pq.remove();
            curr.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode[] lists = new ListNode[]{l1};
        mergeKLists(lists);
    }
}
