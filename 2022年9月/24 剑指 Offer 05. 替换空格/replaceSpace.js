/**
 * @param {string} s
 * @return {string}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了14.37%的用户
 * 内存消耗：41 MB, 在所有 JavaScript 提交中击败了43.38%的用户
 */
var replaceSpace = function (s) {
    const res = [];
    for (let i = 0; i < s.length; i++) {
        if (s[i] === ' ') {
            res.push('%20');
        } else {
            res.push(s[i]);
        }
    }
    return res.join('');
};