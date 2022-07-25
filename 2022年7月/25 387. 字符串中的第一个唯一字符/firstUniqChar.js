/**
 * @param {string} s
 * @return {number}
 */
// 执行用时：64 ms, 在所有 JavaScript 提交中击败了99.64%的用户
// 内存消耗：44.1 MB, 在所有 JavaScript 提交中击败了65.65 % 的用户
var firstUniqChar = function (s) {
    var index = Number.MAX_VALUE;
    var map = new Array(26).fill(-1);//用-1填充
    for (var i = 0; i < s.length; i++) {
        var n = s[i].charCodeAt() - 'a'.charCodeAt()//获取当前字符的map下标
        if (map[n] == -1)
            map[n] = i;//为-1时是第一次操作，保存下标i
        else if (map[n] >= 0)
            map[n] = -2;//大于0为第二次，标记为-2表示已重复不再操作该字母
    }
    for (var i = 0; i < 26; i++) {
        if (map[i] >= 0)
            index = Math.min(index, map[i]);//获取最小且大于等于0的下标
    }
    return index == Number.MAX_VALUE ? -1 : index;
};
