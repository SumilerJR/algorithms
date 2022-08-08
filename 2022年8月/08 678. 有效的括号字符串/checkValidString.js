/**
 * @param {string} s
 * @return {boolean}
 * 执行用时：76 ms, 在所有 JavaScript 提交中击败了8.36%的用户
 * 内存消耗：41.4 MB, 在所有 JavaScript 提交中击败了15.90%的用户
 */
var checkValidString = function (s) {
    let low = 0, high = 0;
    for (let i of s) {
        if (i === '(') {
            low++;
            high++;
        }
        else if (i === ')') {
            low = Math.max(0, --low);
            high--;
            if (high < 0)
                return false;
        }
        else {
            low = Math.max(0, --low);
            high++;
        }
    }
    return low == 0;
};