/**
 * @param {number[]} arr
 * @return {number}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了38.33%的用户
 * 内存消耗：40.9 MB, 在所有 JavaScript 提交中击败了61.67%的用户
 */
var maxChunksToSorted = function (arr) {
    let max = arr[0];
    let count = 0;
    for (let i = 0; i < arr.length; i++) {
        max = Math.max(max, arr[i]);
        if (max === i) {
            count++;
        }
    }
    return count;
};