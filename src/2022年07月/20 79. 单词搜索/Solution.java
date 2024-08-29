//执行用时：82 ms, 在所有 Java 提交中击败了78.25%的用户
//内存消耗：39.4 MB, 在所有 Java 提交中击败了74.86%的用户
// - 回溯 + DFS
class Solution {
    char[][] board;
    String word;
    int row, col;
    //    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    boolean[][] map;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.row = board.length;
        this.col = board[0].length;
        char ch = word.charAt(0);
        map = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == ch && exist(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean exist(int x, int y, int index) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != word.charAt(index) || map[x][y]) {
            return false;
        }
        if (index == word.length() - 1)
            return true;
        map[x][y] = true;
        boolean flag =
                exist(x + 1, y, index + 1) |
                        exist(x - 1, y, index + 1) |
                        exist(x, y - 1, index + 1) |
                        exist(x, y + 1, index + 1);
        map[x][y] = false;
        return flag;
    }
}
