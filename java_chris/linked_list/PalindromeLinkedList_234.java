package linked_list;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_234 {

    // space: O(n) , time: O(n)
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int front = 0;
        int back = arr.size()-1;
        while (front < back) {
            if (!arr.get(front).equals(arr.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public boolean isPalindromeReverse(ListNode head) {
        if (head == null) {
            return false;
        }

        // find end of the linked list and reverse
        ListNode firstHalfEnd = endOfLinkedList(head);
        ListNode reverseSecondHalfStart = reverseSecondHalf(firstHalfEnd.next);

        ListNode firstHalfStart = head;
        ListNode secondHalfStart = reverseSecondHalfStart;
        boolean result = true;
        while (result && secondHalfStart != null) {
            if (firstHalfStart.val != secondHalfStart.val) {
                result = false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        // resotre the list
        firstHalfEnd.next = reverseSecondHalf(reverseSecondHalfStart);
        return result;
    }

    public ListNode endOfLinkedList(ListNode head){
        // 1 2 3 4 3 2 1
        // 1 2 2 1
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseSecondHalf(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        // 2 -> 1   2 <- 1
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
