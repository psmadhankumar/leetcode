package io.lc.prep.design.iterator;

/**
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
 *
 *
 *
 * Example:
 *
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 *
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 *
 *
 * Notes:
 *
 * Please remember to RESET your class variables declared in Vector2D, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * You may assume that next() call will always be valid, that is, there will be at least a next element in the 2d vector when next() is called.
 *
 *
 * Follow up:
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 *
 * Approach: This is bit of small tricky, such that, its very possible to do with i and j.
 */
public class LC251Flatten2DVector {

    int[][] array = null;
    int r = 0;
    int c = 0;
    public LC251Flatten2DVector(int[][] v) {
        array = v;
    }

    public int next() {
        while(array[r].length == 0) { r++; c=0;}

        int next = array[r][c];
        if(c + 1 >= array[r].length) { r++; c=0;}
        else {c++;}

        return next;
    }

    public boolean hasNext() {
        while(r < array.length && array[r].length == 0) { r++; c=0;}

        return r < array.length || (r < array.length && c < array[r].length);

    }
}
