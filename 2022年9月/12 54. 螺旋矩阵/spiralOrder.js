/**
 * @param {number[][]} matrix
 * @return {number[]}
 * 执行用时：76 ms, 在所有 JavaScript 提交中击败了7.50%的用户
 * 内存消耗：41 MB, 在所有 JavaScript 提交中击败了27.41%的用户
 */
var spiralOrder = function (matrix) {
    let m = matrix.length, n = matrix[0].length;
    const arr = new Array(m * n).fill(0);
    let up = 0, down = m - 1, left = 0, right = n - 1;
    let index = 0;
    while (true) {
        for (let i = left; i <= right; i++)
            arr[index++] = matrix[up][i];
        if (++up > down) break;
        for (let i = up; i <= down; i++)
            arr[index++] = matrix[i][right];
        if (--right < left) break;
        for (let i = right; i >= left; i--)
            arr[index++] = matrix[down][i];
        if (--down < up) break;
        for (let i = down; i >= up; i--)
            arr[index++] = matrix[i][left];
        if (++left > right) break;
    }
    return arr;
};


// /**
//  * @param {number[][]} matrix
//  * @return {number[]}
//  */
// var spiralOrder = function (matrix) {
//     let m = matrix.length, n = matrix[0].length;
//     const arr = new Array(m * n).fill(0);
//     let index = 0, k = 0, i = 0;
//     const step = Math.floor((Math.min(m, n) + 1) / 2);
//     while (k < step) {
//         for (i = k; i < n - k - 1; i++) {
//             arr[index++] = matrix[k][i];
//         }
//         for (i = k; i < m - k - 1; i++) {
//             arr[index++] = matrix[i][n - k - 1];
//         }
//         for (i = n - k - 1; i > k; i--) {
//             arr[index++] = matrix[m - k - 1][i];
//         }
//         for (i = m - k - 1; i > k; i--) {
//             arr[index++] = matrix[i][k];
//         }
//         k++;
//     }
//     return arr;
// };