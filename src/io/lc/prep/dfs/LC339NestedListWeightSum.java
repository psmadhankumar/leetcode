package io.lc.prep.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 *
 * Approach:
 * Use the queue to go level by level and keep multiplying to it.
 */
public class LC339NestedListWeightSum implements NestedInteger{

    public int depthSum(List<NestedInteger> nestedList) {
        LinkedList<NestedInteger> queue = new LinkedList<>();

        for(int i = 0; i < nestedList.size(); i++) {
            queue.add(nestedList.get(i));
        }

        int level = 1;
        int result = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                NestedInteger ni = queue.poll();

                int current = 0;
                if(ni.isInteger()) {
                    current = current + level * ni.getInteger();
                } else {
                    for(int j = 0; j < ni.getList().size(); j++) {
                        queue.add(ni.getList().get(j));
                    }
                }

                result += current;
            }

            level++;
        }

        return result;
    }


    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public void setInteger(int value) {

    }

    @Override
    public void add(NestedInteger ni) {

    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}
