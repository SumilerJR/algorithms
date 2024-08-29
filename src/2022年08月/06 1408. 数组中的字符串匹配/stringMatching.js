/**
 * @param {string[]} words
 * @return {string[]}
 */
var stringMatching = function (words) {
    const result = [];
    for (let s1 of words) {
        for (let s2 of words) {
            if (s1 !== s2 && s2.includes(s1)) {
                result.push(s1);
                break;
            }
        }
    }
    return result;
};

/**
 * @param {string[]} words
 * @return {string[]}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了58.82%的用户
 * 内存消耗：43.5 MB, 在所有 JavaScript 提交中击败了5.88%的用户
 */
var stringMatching = function (words) {
    const result = [];
    for (let i in words) {
        for (let j in words) {
            if (i !== j && words[j].includes(words[i])) {
                result.push(words[i]);
                break;
            }
        }
    }
    return result;
};

/**
 * @param {string[]} words
 * @return {string[]}
 * 执行用时：60 ms, 在所有 JavaScript 提交中击败了81.18%的用户
 * 内存消耗：42.1 MB, 在所有 JavaScript 提交中击败了9.41%的用户
 */
var stringMatching = function (words) {
    const result = new Set();
    for (let s1 of words) {
        for (let s2 of words) {
            if (s1.includes(s2) && s1 !== s2) {
                result.add(s2);
            }
        }
    }
    return [...result];
};