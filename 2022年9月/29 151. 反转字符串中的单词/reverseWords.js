/**
 * @param {string} s
 * @return {string}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了48.85%的用户
 * 内存消耗：42.7 MB, 在所有 JavaScript 提交中击败了96.44%的用户
 */
var reverseWords = function (s) {
    const arr = [];
    s = s.trim();
    for (let left = 0, right = 0; right < s.length;) {
        while (right < s.length && s[right] !== ' ') {
            right++;
        }
        if (right <= s.length) {
            arr.push(s.slice(left, right));
            left = right;
            while (left < s.length && s[left] == ' ') {
                left++;
            }
            right = left;
        }
    }
    arr.reverse();
    return arr.join(' ');
};