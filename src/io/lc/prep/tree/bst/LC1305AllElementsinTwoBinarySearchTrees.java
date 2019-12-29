package io.lc.prep.tree.bst;

import io.lc.prep.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * Example 2:
 *
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * Example 3:
 *
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 *
 * Constraints:
 *
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 */
class LC1305AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<Integer>();
        List<Integer> second= new ArrayList<Integer>();

        bst(root1, first);
        bst(root2, second);

        return merge(first, second);
    }

    private List<Integer> merge(List<Integer> first, List<Integer> second) {

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < first.size() && j < second.size()) {
            if(first.get(i) < second.get(j)) { result.add(first.get(i)); i++;}
            else  {result.add(second.get(j)); j++;}
        }

        while(i < first.size()) {
            result.add(first.get(i));
            i++;
        }

        while(j < second.size()) {
            result.add(second.get(j));
            j++;
        }

        return result;
    }

    private void bst(TreeNode root, List<Integer> result) {
        if(root == null) return;

        bst(root.left, result);
        result.add(root.val);
        bst(root.right, result);
    }

}
