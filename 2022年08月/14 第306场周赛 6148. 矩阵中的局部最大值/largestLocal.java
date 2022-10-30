class Solution {
    int[][] grid;
    int[][] maxLocal;
    public int[][] largestLocal(int[][] grid) {
        this.grid = grid;
        int row = grid.length, col = grid[0].length;
        this.maxLocal = new int[row - 2][col - 2];
        for (int i = 0; i < maxLocal.length; i++) {
            for (int j = 0; j < maxLocal[0].length; j++) {
                maxLocal[i][j] = help(i + 1, j + 1);
            }
        }
        return maxLocal;
    }
    public int help(int x, int y) {
        int max = grid[x - 1][y - 1];
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                max = Math.max(max, grid[x + i][y + j]);
            }
        }
        return max;
    }
}