/**
 * @param {string[]} strs
 * @return {string[][]}
 * 执行用时：112 ms, 在所有 JavaScript 提交中击败了55.00%的用户
 * 内存消耗：50.7 MB, 在所有 JavaScript 提交中击败了79.11%的用户
 */
var groupAnagrams = function (strs) {
    const map = new Map();
    for (let i = 0; i < strs.length; i++) {
        let s = Array.from(strs[i]).sort().toString();
        if (map.has(s)) {
            map.get(s).push(strs[i]);
        } else {
            map.set(s, [strs[i]]);
        }
    }
    return Array.from(map.values());
};