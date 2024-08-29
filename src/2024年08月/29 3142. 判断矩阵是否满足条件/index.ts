// 3142. 判断矩阵是否满足条件 - 力扣（LeetCode）
// https://leetcode.cn/problems/check-if-grid-satisfies-conditions/
// 久违的算法……来签个到吧
function satisfiesConditions(grid: number[][]): boolean {
    const col = grid.length, row = grid[0].length;
    for (let i = 0; i < col; i++) {
        for (let j = 0; j < row; j++) {
            if (i < col - 1) {
                if (grid[i][j] !== grid[i + 1][j]) return false;
            }
            if (j < row - 1) {
                if (grid[i][j] === grid[i][j + 1]) return false;
            }
        }
    }
    return true;
};