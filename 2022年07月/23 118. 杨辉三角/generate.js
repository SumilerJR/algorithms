/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function (numRows) {
    const ans = new Array(numRows).fill(0);
    for (let i = 0; i < numRows; i++) {
        ans[i] = new Array(i + 1).fill(1);
    }
    for (let i = 2; i < numRows; i++) {
        for (let j = 1; j < i; j++) {
            ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
        }
    }
    return ans;
};
