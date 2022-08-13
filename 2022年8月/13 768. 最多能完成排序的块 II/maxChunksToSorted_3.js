/**
 * @param {number[]} arr
 * @return {number}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了75.56%的用户
 * 内存消耗：43.9 MB, 在所有 JavaScript 提交中击败了13.33%的用户
 * 排序 + 哈希表
 * 对比原数组和排序后的数组，若区间内数字出现的次数相同，即map为空时，是一个可划分的区间
 * */
var maxChunksToSorted = function (arr) {
    const map = new Map();
    const sortArr = [...arr].sort((a, b) => a - b);
    let ans = 0;
    for (let i = 0; i < sortArr.length; i++) {
        const x = arr[i], y = sortArr[i];
        map.set(x, (map.get(x) || 0) + 1);
        if (map.get(x) === 0) {
            map.delete(x);
        }
        map.set(y, (map.get(y) || 0) - 1);
        if (map.get(y) === 0) {
            map.delete(y);
        }
        if (map.size === 0) {
            ans++;
        }
    }
    return ans;
};