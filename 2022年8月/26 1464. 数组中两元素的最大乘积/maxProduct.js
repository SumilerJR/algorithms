/**
 * @param {number[]} nums
 * @return {number}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了59.14%的用户
 * 内存消耗：42 MB, 在所有 JavaScript 提交中击败了13.44%的用户
 */
var maxProduct = function (nums) {
    let a = Number.MIN_VALUE, b = Number.MIN_VALUE;
    for (let i of nums) {
        if (i >= a) {
            b = a;
            a = i;
        }
        else if (i > b && a != Number.MIN_VALUE) {
            b = i;
        }
    }
    return (a - 1) * (b - 1);
};


/**
 * @param {number[]} nums
 * @return {number}
 * 执行用时：56 ms, 在所有 JavaScript 提交中击败了91.94%的用户
 * 内存消耗：41.6 MB, 在所有 JavaScript 提交中击败了47.31%的用户
 */
var maxProduct = function (nums) {
    nums.sort((a, b) => a - b);
    return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
};