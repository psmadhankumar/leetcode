package io.lc.prep.design.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 *
 *
 *
 * Example:
 *
 * Input:
 * v1 = [1,2]
 * v2 = [3,4,5,6]
 * Output: [1,3,2,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,3,2,4,5,6].
 *
 *
 * Follow up:
 *
 * What if you are given k 1d vectors? How well can your code be extended to such cases?
 *
 * Clarification for the follow up question:
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:
 *
 * Input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 *
 * Output: [1,4,8,2,5,9,3,6,7].
 *
 *
 */
public class LC281ZigzagIterator {

    Queue<Node> queue = null;
    public LC281ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if(v1 != null && v1.size() > 0) queue.add(new Node(v1, 0));
        if(v2 != null && v2.size() > 0) queue.add(new Node(v2, 0));
    }

    public int next() {
        Node node = queue.poll();
        List<Integer> array = node.array;
        int index = node.index;

        int next = array.get(index);

        if(index + 1 < array.size())  {
            node.index = index + 1;
            queue.add(node);
        }

        return next;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    class Node {
        List<Integer> array;
        int index;

        public Node(List<Integer> arr, int idx) {
            array = arr;
            index = idx;
        }
    }

}
