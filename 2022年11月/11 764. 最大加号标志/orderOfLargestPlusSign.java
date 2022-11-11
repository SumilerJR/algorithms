class Solution {
    int[][] grid;
    int m;
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        grid = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(grid[i], 1);
        m = n;
        int res = 0;
        for (int i = 0; i < mines.length; i++) {
            int x = mines[i][0];
            int y = mines[i][1];
            grid[x][y] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    public int dfs(int x, int y) {
        int res = 1;
        for (int i = 1; ;i++) {
            int up = x - i;
            int bottom = x + i;
            int left = y - i;
            int right = y + i;
            if (up < 0 || bottom >= m || left < 0 || right >= m) {
                break;
            } else if (grid[up][y] == 0 || grid[bottom][y] == 0 || grid[x][left] == 0 || grid[x][right] == 0) {
                break;
            } else {
                res++;
            }
        }
        return res;
    }
}