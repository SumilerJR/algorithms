/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 * 执行用时：52 ms, 在所有 JavaScript 提交中击败了100.00%的用户
 * 内存消耗：43.1 MB, 在所有 JavaScript 提交中击败了25.58%的用户
 */
var orderlyQueue = function (s, k) {
    if (k === 1) {
        let ans = s;
        for (let i = 0; i < s.length - 1; ++i) {
            const n = s.length;
            s = s.substring(1, n) + s[0];//取子串且拼接首个字符，等同于将首字符移动到尾部
            ans = ans < s ? ans : s;//取最小值
        }
        return ans;
    }
    return [...s].sort().join('');//...扩展运算符将s所有值赋给数组，调用sort排序，join将该数组转回字符串且间隔符号为空
};