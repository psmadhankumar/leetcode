package io.lc.prep.linkedlist;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class LC148SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        // take the mid previous point, seperate the take two heads
        // keep doing until there is only one element
        // then merge

        ListNode midPrevious = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            midPrevious = midPrevious.next;
            fast = fast.next.next;
        }

        ListNode second = midPrevious.next;
        midPrevious.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(second);

        ListNode temp = new ListNode(-1);
        ListNode tail = temp;
        while(left != null || right != null) {

            if(left == null) { tail.next = right; right = null;}
            else if(right == null) {tail.next = left; left = null; }
            else {
                if(left.val > right.val) {
                    tail.next = right;
                    right = right.next;
                } else if(right.val > left.val) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }
                tail = tail.next;
            }
        }

        return temp.next;
    }
}
