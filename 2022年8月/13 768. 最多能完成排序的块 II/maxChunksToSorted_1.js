/**
 * @param {number[]} arr
 * @return {number}
 * 执行用时：72 ms, 在所有 JavaScript 提交中击败了35.56%的用户
 * 内存消耗：43.1 MB, 在所有 JavaScript 提交中击败了35.56%的用户
 */
var maxChunksToSorted = function (arr) {
    let ans = 0;
    const maxArr = new Array(arr.length);
    const minArr = new Array(arr.length);
    let temp = Number.MIN_SAFE_INTEGER;
    for (let i = 0; i < arr.length; i++) {
        maxArr[i] = temp = Math.max(temp, arr[i]);
    }
    temp = Number.MAX_SAFE_INTEGER;
    for (let i = arr.length - 1; i >= 0; i--) {
        minArr[i] = temp = Math.min(temp, arr[i]);
    }
    for (let i = 0; i < arr.length; i++) {
        if (i === arr.length - 1 || maxArr[i] <= minArr[i + 1]) {
            ans++;
        }
    }
    return ans;
};