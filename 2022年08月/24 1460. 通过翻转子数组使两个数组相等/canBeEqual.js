/**
 * @param {number[]} target
 * @param {number[]} arr
 * @return {boolean}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了75.28%的用户
 * 内存消耗：43.9 MB, 在所有 JavaScript 提交中击败了26.97%的用户
 */
var canBeEqual = function (target, arr) {
    let map = new Map();
    for (let i in target) {
        map.set(target[i], (map.get(target[i]) || 0) + 1);
    }
    for (let i in arr) {
        if (!map.get(arr[i]))
            return false;
        map.set(arr[i], map.get(arr[i]) - 1);
    }
    return true;
};