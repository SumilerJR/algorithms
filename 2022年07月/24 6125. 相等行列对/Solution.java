//执行用时：8 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：46.8 MB, 在所有 Java 提交中击败了100.00%的用户
// 周赛第二题
class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int row = grid.length, col = grid[0].length;
        int[][] grid2 = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid2[j][i] = grid[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (Arrays.equals(grid[i], grid2[j]))
                    count++;
            }
        }
        return count;
    }
}
