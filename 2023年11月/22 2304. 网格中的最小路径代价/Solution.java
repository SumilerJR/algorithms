class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int col = grid.length, row = grid[0].length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[col][row];
        dp[0] = grid[0].clone(); // 这里初始化一下
        for (int i = 1; i < col; i++) {
            for (int j = 0; j < row; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < row; k++) {
                    int temp = moveCost[grid[i - 1][k]][j] + dp[i - 1][k] + grid[i][j];
                    dp[i][j] = Math.min(dp[i][j], temp);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            ans = Math.min(ans, dp[col - 1][i]);
        }
        return ans;
    }
}