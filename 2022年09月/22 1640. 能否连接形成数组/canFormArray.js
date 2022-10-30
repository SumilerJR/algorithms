/**
 * @param {number[]} arr
 * @param {number[][]} pieces
 * @return {boolean}
 * 执行用时：76 ms, 在所有 JavaScript 提交中击败了8.06%的用户
 * 内存消耗：41.9 MB, 在所有 JavaScript 提交中击败了11.29%的用户
 */
var canFormArray = function (arr, pieces) {
    const map = new Map();
    for (let i of pieces) {
        map.set(i[0], i);
    }
    for (let i = 0; i < arr.length;) {
        if (map.has(arr[i])) {
            for (let j of map.get(arr[i])) {
                if (arr[i++] !== j) {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
    return true;
};