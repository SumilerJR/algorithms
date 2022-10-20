/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 * 执行用时：52 ms, 在所有 JavaScript 提交中击败了97.78%的用户
 * 内存消耗：40.9 MB, 在所有 JavaScript 提交中击败了62.22%的用户
 */
var kthGrammar = function (n, k) {
    if (n === 1) {
        return 0;
    }
    const mid = 2 ** (n - 2);
    if (k <= mid) {
        return kthGrammar(n - 1, k);
    } else {
        return 1 ^ kthGrammar(n - 1, k - mid);
    }
};