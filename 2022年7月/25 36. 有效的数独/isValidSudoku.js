/**
 * @param {character[][]} board
 * @return {boolean}
 */
// 执行用时：72 ms, 在所有 JavaScript 提交中击败了85.24%的用户
// 内存消耗：45.6 MB, 在所有 JavaScript 提交中击败了47.93 % 的用户
// 遇到一个大坑，JavaScript里除数是不会自动取整的，会变成浮点数继续算，得调用一下Math.floor()去掉余数……
var isValidSudoku = function (board) {
    const row = new Array(9).fill(false).map(() => new Array(9).fill(false));
    const col = new Array(9).fill(false).map(() => new Array(9).fill(false));
    const matrix = new Array(9).fill(false).map(() => new Array(9).fill(false));
    for (var i = 0; i < 9; i++) {
        for (var j = 0; j < 9; j++) {
            if (board[i][j] != '.') {
                var n = board[i][j] - 1;
                if (row[i][n] || col[j][n] || matrix[Math.floor((i / 3)) * 3 + Math.floor((j / 3))][n])
                    return false;
                else {
                    row[i][n] = true;
                    col[j][n] = true;
                    matrix[Math.floor((i / 3)) * 3 + Math.floor((j / 3))][n] = true;
                }
            }
        }
    }
    return true;
};
