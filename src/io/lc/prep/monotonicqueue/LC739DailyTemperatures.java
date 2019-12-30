package io.lc.prep.monotonicqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how
 * many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 * Approach: The superbly a monotonic queue approach, such that, increasing order queue. Below was solved using deque
 * approach, but, looking at the method used, this is nothing but stack manipulation. Simply, this can be solved
 * with using stack instead of Deque. Just keep popping when higher temperature comes. Note, to traverse from back.
 *
 *
 */
public class LC739DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {

        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[T.length];

        for(int i = T.length-1; i >= 0; i--) {

            while(!queue.isEmpty() && T[queue.peekFirst()] <= T[i]) {
                queue.removeFirst();
            }
            if(queue.size() == 0) result[i] = 0;
            else {
                int previousIndex = queue.peekFirst();
                result[i] = previousIndex - i;
            }

            queue.addFirst(i);
        }

        return result;
    }

}
