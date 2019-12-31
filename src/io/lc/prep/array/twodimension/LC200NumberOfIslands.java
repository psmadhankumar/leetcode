package io.lc.prep.array.twodimension;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 *
 * Approach:  Just a DFS solution, if we can modify the array then change on it, else, use visited array.
 */
public class LC200NumberOfIslands {

    public int numIslands(char[][] grid) {
        int island = 0;

        if(grid.length == 0) return island;

        for(int r = 0; r<grid.length; r++) {
            for(int c =0; c<grid[0].length; c++) {

                if(grid[r][c] == '1') {
                    island++;
                    dfs(grid, r, c);
                }
            }
        }

        return island;
    }

    private void dfs(char[][] grid, int r, int c) {

        if(r<0 || r>=grid.length || c < 0 || c >= grid[0].length) return;
        if(grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r,   c-1);
        dfs(grid, r,   c+1);
    }
}
