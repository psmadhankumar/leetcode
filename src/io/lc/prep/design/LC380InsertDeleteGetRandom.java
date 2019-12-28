package io.lc.prep.design;


import java.util.*;

/**
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class LC380InsertDeleteGetRandom {

    List<Integer> elements = null;
    Map<Integer, Integer> map = null;
    Random random = new Random();

    /** Initialize your data structure here. */
    public LC380InsertDeleteGetRandom() {
        //elements keeps the inserted element
        elements = new ArrayList<>();

        //map keeps element and its index
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        // add to list and keep the position of element in map
        elements.add(val);
        map.put(val, elements.size() -1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int elementPosition = map.get(val);
        int lastPosition = elements.size() -1;

        // change the elements array's last position as removing elements position
        map.put(elements.get(lastPosition), elementPosition);
        map.remove(val);
        //then set the same in elements array
        elements.set(elementPosition, elements.get(lastPosition));
        //finally remove the last element in the array. So that O(1) operation
        elements.remove(lastPosition);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }
}
