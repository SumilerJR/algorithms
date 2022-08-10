/**
 * @param {number[]} nums
 * @return {number}
 * 执行用时：48 ms, 在所有 JavaScript 提交中击败了98.82%的用户
 * 内存消耗：41.4 MB, 在所有 JavaScript 提交中击败了10.59%的用户
 */
var minStartValue = function (nums) {
    let num = 1;
    let sum = 0;
    for (let n of nums) {
        sum += n;
        if (sum < 0) {
            num = Math.max(num, -sum + 1);
        }
    }
    return num;
};