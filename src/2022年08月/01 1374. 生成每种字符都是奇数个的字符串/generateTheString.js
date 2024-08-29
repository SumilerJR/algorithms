/**
 * @param {number} n
 * @return {string}
 */
// 执行用时：56 ms, 在所有 JavaScript 提交中击败了88.89%的用户
// 内存消耗：41.5 MB, 在所有 JavaScript 提交中击败了24.07 % 的用户
var generateTheString = function (n) {
    let arr = "";
    if (n % 2 == 0) {
        for (let i = 0; i < n - 1; i++)
            arr += 'a';
        arr += 'b';
    }
    else {
        for (let i = 0; i < n; i++)
            arr += 'a';
    }
    return arr;
};
// 执行用时：56 ms, 在所有 JavaScript 提交中击败了88.89 % 的用户
// 内存消耗：40.7 MB, 在所有 JavaScript 提交中击败了96.30 % 的用户
var generateTheString = function (n) {
    return n % 2 ? 'a'.repeat(n) : 'a'.repeat(n - 1) + 'b';
};
