package io.lc.prep.array.twodimension;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 * Approach: Since each array is sorted, check the first cell and last cell for each row and if the target
 * falls within the range, then, do the binary search on it.
 *
 */
public class LC74Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length ==0) return false;

        int rLen = matrix.length-1;
        int cLen = matrix[0].length-1;

        for(int r = 0; r <= rLen; r++) {
            if(target >= matrix[r][0] && target <= matrix[r][cLen]) {
                return elementBinarySearch(matrix[r], target);
            }
        }

        return false;
    }


    private boolean elementBinarySearch(int[] array, int target) {

        int lo = 0;
        int hi = array.length -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(target == array[mid]) return true;
            else if(target > array[mid]) { lo = mid + 1; }
            else { hi = mid - 1;}
        }

        return false;
    }
}
