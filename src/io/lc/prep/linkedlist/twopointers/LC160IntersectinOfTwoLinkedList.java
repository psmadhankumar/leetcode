package io.lc.prep.linkedlist.twopointers;

import io.lc.prep.linkedlist.ListNode;

/**
 * Example 1:
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before
 * the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Approach:
 *
 * TIPS: Have two pointers one from each head and when one hits null switch it to other head.
 *
 * Point1: 4 1 8 4 5 5 0 1 8 4 5
 * Point2: 5 0 1 8 4 5 4 1 8
 */
public class LC160IntersectinOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode point1 = headA;
        ListNode point2 = headB;
        while(point1 != point2) {
            point1 = point1 == null ? headA : point1.next;
            point2 = point2 == null ? headB : point2.next;
        }

        return point1 ;
    }
}
