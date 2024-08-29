// 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：41.2 MB, 在所有 Java 提交中击败了12.41%的用户
class Solution {
    int row, col;
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 2)
                    dfs(grid, i, j, 2);//深搜计算路径
            }
        }
        int path = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1)
                    return -1;//有1的直接返回-1
                else
                    path = Math.max(path, grid[i][j]);//取最大值
            }
        }
        return path == 0 ? 0 : path - 2;//为0时返回0，否则要减去初始的2
    }
    public void dfs(int[][] grid, int x, int y, int path) {
        if (x < 0 || x > row - 1 || y < 0 || y > col - 1)
            return;//越界结束
        if (grid[x][y] != 1 && grid[x][y] < path)
            return;//若被标记过且比当前路径小的，也结束递归
        grid[x][y] = path++;//标记到当前坐标的路径
        for(int[] dir : direction) {
            dfs(grid, x + dir[0], y + dir[1], path);//上下左右深搜
        }
    }
}
