package io.lc.prep.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 * Example:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 *
 * Note:
 *
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 *
 * TODO: This needs to be changed to correct solution without using hashmap impl.
 */
public class LC705DesignHashSet {

    private static Object OBJECT = new Object();
    private Map<Integer, Object> map = null;

    /** Initialize your data structure here. */
    public LC705DesignHashSet() {
        map = new HashMap<>();
    }

    public void add(int key) {
        map.put(key, OBJECT);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
