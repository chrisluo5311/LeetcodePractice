package queue;

public class QueueList2 {
    static class Node {
        Integer val;
        Node next;
        public Node(Integer val) {
            this.val = val;
        }
    }

    Integer[] nums;
    Node node_start = null;
    Node node_end = null;

    public QueueList2(Integer[] nums) {
        this.nums = nums;
    }

    public void buildQueue() {
        for (int i = 0; i < nums.length; i++) {
            offer(nums[i]);
        }
    }

    private void offer(Integer val) {
        if (node_start == null) {
            node_start = new Node(val);
            node_end = node_start;
        } else {
            Node new_node = new Node(val);
            node_end.next = new_node;
            this.node_end = new_node;
        }
    }

    public Integer poll() {
        if (node_start == null) {
            return null;
        }

        Node front = node_start;
        node_start = node_start.next;

        if (node_start == null) {
            node_end = null;
        }
        return front.val;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        QueueList2 queue_list = new QueueList2(nums);
        queue_list.buildQueue();

        // full - extend the storage size
        queue_list.offer(6);

        Integer num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();

        // empty
        num = queue_list.poll();

        System.out.println();
    }
}
