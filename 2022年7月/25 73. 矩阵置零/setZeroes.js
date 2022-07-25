/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
// 执行用时：72 ms, 在所有 JavaScript 提交中击败了86.80%的用户
// 内存消耗：44.6 MB, 在所有 JavaScript 提交中击败了10.98 % 的用户
// 利用了JavaScript数组可为任何值，这里利用了-0和0的区别哈哈哈哈
var setZeroes = function (matrix) {
    for (var i = 0; i < matrix.length; i++) {
        for (var j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] === 0)
                matrix[i][j] = -0;
        }
    }
    for (var i = 0; i < matrix.length; i++) {
        for (var j = 0; j < matrix[0].length; j++) {
            if (1 / matrix[i][j] === 1 / -0)
                help(matrix, i, j);
        }
    }
};

var help = function (matrix, x, y) {
    for (var i = 0; i < matrix[0].length; i++) {
        if (matrix[x][i] !== 0)
            matrix[x][i] = 0;
    }

    for (var i = 0; i < matrix.length; i++) {
        if (matrix[i][y] !== 0)
            matrix[i][y] = 0;
    }
}
