//又是做过的。。
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] map = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                map[i][j] = getMax(grid, i + 1, j + 1);
            }
        }
        return map;
    }
    public int getMax(int[][] grid, int x, int y) {
        int max = grid[x - 1][y - 1];
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}