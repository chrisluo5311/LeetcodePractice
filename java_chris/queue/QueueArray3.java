package queue;

public class QueueArray3 {
    Integer[] ary;
    Integer[] queue;
    Integer i_front = null;
    Integer i_end = null;

    public QueueArray3(Integer[] ary) {
        this.ary = ary;
    }

    public void buildQueue(){
        this.queue = new Integer[this.ary.length];
        for (int i = 0; i < ary.length; i++) {
            offer(ary[i]);
        }
    }

    private void offer(Integer val) {
        if (size() == queue.length){
            expandSpace();
        }

        if (size() == 0){
            i_front = 0;
            i_end = 0;
            queue[i_end] = val;
        } else {
            i_end++; // circular array
            i_end %= queue.length;
            queue[i_end] = val;
        }

    }

    private int size() {
        if (i_front == null && i_end == null) {
            return 0;
        } else if (i_end >= i_front) {
            return i_end - i_front + 1;
        } else if (i_end < i_front) {
            //回圈繞回來時
            return (queue.length - i_front) + i_end + 1;
        }
        return -1;
    }

    private void expandSpace() {
        Integer[] new_queue = new Integer[this.queue.length * 2];
        int i = 0;
        while (true) {
            if (size() == 0) break;

            Integer val = poll();
            new_queue[i] = val;
            i++;
        }

        this.i_front = 0;
        this.i_end = i - 1;

        this.queue = new_queue;
    }

    private Integer poll() {
        if (size() == 0) return null;

        Integer val = queue[i_front];
        queue[i_front] = null;

        if (size() == 1){
            i_front = null;
            i_end = null;
        } else {
            i_front++;
            i_front %= queue.length;
        }
        return val;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        QueueArray3 queue_array = new QueueArray3(nums);
        queue_array.buildQueue();

        // full - extend the storage size
        queue_array.offer(6);

        Integer val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();

        // empty
        val = queue_array.poll();

        // circular queue - i_end test
        queue_array.offer(11);
        queue_array.offer(12);
        queue_array.offer(13);
        queue_array.offer(14);
        queue_array.offer(15);
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();

        for (int i = 0; i < 80; i++) {
            queue_array.offer(30 + i);
        }

        System.out.println();
    }

}
