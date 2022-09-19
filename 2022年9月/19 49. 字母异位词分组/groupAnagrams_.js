/**
 * @param {string[]} strs
 * @return {string[][]}
 * 执行用时：188 ms, 在所有 JavaScript 提交中击败了8.59%的用户
 * 内存消耗：55 MB, 在所有 JavaScript 提交中击败了5.02%的用户
 * 计数
 */
var groupAnagrams = function (strs) {
    const map = new Map();
    for (let str of strs) {
        let count = new Array(26).fill(0);
        for (let ch of str) {
            count[ch.charCodeAt() - 'a'.charCodeAt()]++;
        }
        map[count] ? map[count].push(str) : map[count] = [str];
    }
    return Array.from(map.values());
};

//使用Object类型
var groupAnagrams = function (strs) {
    const map = new Object();
    for (let s of strs) {
        const count = new Array(26).fill(0);
        for (let c of s) {
            count[c.charCodeAt() - 'a'.charCodeAt()]++;
        }
        map[count] ? map[count].push(s) : map[count] = [s];
    }
    return Object.values(map);
};