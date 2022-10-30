/**
 * @param {number} n
 * @return {number[][]}
 * 执行用时：56 ms, 在所有 JavaScript 提交中击败了86.57%的用户
 * 内存消耗：41.1 MB, 在所有 JavaScript 提交中击败了56.91%的用户
 */
var generateMatrix = function (n) {
    const arr = new Array(n).fill(0).map(() => new Array(n).fill(0));
    const m = Math.floor(n / 2);
    let i = 0, j = n - 1, x = 1, l = Math.floor(n / 2);
    for (; i < l; i++, j--) {
        for (let k = 0; k < j - i; k++) {
            arr[i][i + k] = x++;
        }
        for (let k = 0; k < j - i; k++) {
            arr[i + k][j] = x++;
        }
        for (let k = j - i; k > 0; k--) {
            arr[j][i + k] = x++;
        }
        for (let k = j - i; k > 0; k--) {
            arr[i + k][i] = x++;
        }
    }
    if (n % 2 == 1) {
        arr[i][j] = x;
    }
    return arr;
};


