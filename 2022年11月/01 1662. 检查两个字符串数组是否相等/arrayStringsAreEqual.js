/**
 * @param {string[]} word1
 * @param {string[]} word2
 * @return {boolean}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了45.45%的用户
 * 内存消耗：41.1 MB, 在所有 JavaScript 提交中击败了56.82%的用户
 */
var arrayStringsAreEqual = function (word1, word2) {
    return word1.join("") == word2.join("");
};