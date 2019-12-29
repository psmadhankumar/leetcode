package io.lc.prep.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 *
 */

public class LC346MovingAverageFromDataStream {

    int capacity = 0;
    int sum = 0;
    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public LC346MovingAverageFromDataStream(int size) {
        capacity = size;
    }

    public double next(int val) {
        sum = sum + val;
        queue.add(val);

        if(queue.size() > capacity) {
            int oldValue = queue.poll();
            sum = sum - oldValue;
        }

        return (double) sum / queue.size();
    }
}
