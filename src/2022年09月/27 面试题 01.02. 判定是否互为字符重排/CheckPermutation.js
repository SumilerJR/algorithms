/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了34.40%的用户
 * 内存消耗：41.5 MB, 在所有 JavaScript 提交中击败了5.40%的用户
 */
var CheckPermutation = function (s1, s2) {
    return Array.from(s1).sort().toString() === Array.from(s2).sort().toString();
};


/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 * 执行用时：48 ms, 在所有 JavaScript 提交中击败了97.40%的用户
 * 内存消耗：40.9 MB, 在所有 JavaScript 提交中击败了48.40%的用户
 */
var CheckPermutation = function (s1, s2) {
    const map = new Map();
    for (let s of s1) {
        map.set(s, (map.get(s) || 0) + 1);
    }
    for (let s of s2) {
        if (!map.has(s) || map.get(s) === 0) {
            return false;
        } else {
            map.set(s, map.get(s) - 1);
        }
    }
    return true;
};