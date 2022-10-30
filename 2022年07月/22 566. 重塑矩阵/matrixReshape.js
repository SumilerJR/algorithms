/**
 * @param {number[][]} mat
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */

// 执行用时：104 ms, 在所有 JavaScript 提交中击败了7.92%的用户
// 内存消耗：44.6 MB, 在所有 JavaScript 提交中击败了28.33 % 的用户
var matrixReshape = function (mat, r, c) {
    const row = mat.length;
    const col = mat[0].length;
    if (r * c != row * col)
        return mat;
    let x = 0, y = 0;
    const ans = new Array(r).fill(0).map(() => new Array(c).fill(0));
    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            ans[x][y++] = mat[i][j];
            if (y == c && x != r - 1) {
                y = 0;
                x++;
            }
        }
    }
    return ans;
};


/**
 * @param {number[][]} mat
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
// 执行用时：80 ms, 在所有 JavaScript 提交中击败了64.38%的用户
// 内存消耗：44.7 MB, 在所有 JavaScript 提交中击败了20.73 % 的用户
var matrixReshape = function (nums, r, c) {
    const m = nums.length;
    const n = nums[0].length;
    if (m * n != r * c) {
        return nums;
    }

    const ans = new Array(r).fill(0).map(() => new Array(c).fill(0));
    for (let x = 0; x < m * n; ++x) {
        ans[Math.floor(x / c)][x % c] = nums[Math.floor(x / n)][x % n];
    }
    return ans;
};
