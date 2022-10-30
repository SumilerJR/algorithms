/**
 * @param {number[][]} matrix
 * @return {number[]}
 * 执行用时：56 ms, 在所有 JavaScript 提交中击败了82.32%的用户
 * 内存消耗：40.9 MB, 在所有 JavaScript 提交中击败了43.25%的用户
 */
var spiralOrder = function (matrix) {
    let m = matrix.length, n = matrix[0].length;
    const arr = new Array(m * n).fill(0);
    let index = 0, k = 0, i = 0;
    const step = Math.floor((Math.min(m, n) + 1) / 2);
    while (k < step) {
        for (i = k; i < n - k; i++) {
            arr[index++] = matrix[k][i];
        }
        for (i = k + 1; i < m - k; i++) {
            arr[index++] = matrix[i][n - k - 1];
        }
        for (i = n - k - 2; i >= k && (k !== m - k - 1); i--) {
            arr[index++] = matrix[m - k - 1][i];
        }
        for (i = m - k - 2; i >= k + 1 && (k !== n - k - 1); i--) {
            arr[index++] = matrix[i][k];
        }
        k++;
    }
    return arr;
};