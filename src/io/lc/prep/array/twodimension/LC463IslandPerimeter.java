package io.lc.prep.array.twodimension;

/**
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Approach: This is straight forward solution, such that, traverse each cell and
 * for each cell "1" then move four directions and keep adding "1" either cell falls outside of grid or if cell is zero.
 * 
 */
public class LC463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int rLen = grid.length;
        int cLen = grid[0].length;

        int perimeter = 0;
        int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}};

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {

                if(grid[r][c] == 0) continue;

                int current = 0;

                for(int[] dir : dirs) {
                    int d0 = dir[0];
                    int d1 = dir[1];

                    int row = r + d0;
                    int col = c + d1;
                    if(row < 0) current += 1;
                    else if(col < 0) current += 1;
                    else if(row >= rLen) current += 1;
                    else if(col >= cLen) current += 1;
                    else if(grid[row][col] == 0) current += 1;
                }
                perimeter += current;
            }
        }

        return perimeter;
    }
}
