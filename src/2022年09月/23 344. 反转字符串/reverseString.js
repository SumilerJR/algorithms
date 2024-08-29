/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 * 执行用时：84 ms, 在所有 JavaScript 提交中击败了77.94%的用户
 * 内存消耗：47.9 MB, 在所有 JavaScript 提交中击败了71.68%的用户
 */
var reverseString = function (s) {
    let left = 0, right = s.length - 1;
    while (left < right) {
        [s[left++], s[right--]] = [s[right], s[left]];
    }
};