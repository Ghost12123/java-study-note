package com.blank.study.algorithm;

/**
 * @author wudc
 * @date 2020/10/21 23:58
 */
public class Code200 {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     * 示例 1：
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     */
    public int numIslands(char[][] grid) {
        // 记录遇到的岛屿数
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果碰到岛屿, 先上岛转转
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 踏遍这个岛屿
     */
    public void dfs(char[][] grid, int x, int y) {
        // 标记这个位置走过
        grid[x][y] = '0';

        // right
        if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
            dfs(grid, x, y + 1);
        }
        // down
        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
            dfs(grid, x + 1, y);
        }
        // left
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            dfs(grid, x, y - 1);
        }
        // up
        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            dfs(grid, x - 1, y);
        }
    }

    public static void main(String[] args) {
        Code200 code200 = new Code200();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(code200.numIslands(grid));
    }
}
