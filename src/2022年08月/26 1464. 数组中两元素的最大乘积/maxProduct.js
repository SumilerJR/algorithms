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


/**
 * @param {number[]} nums
 * @return {number}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了37.63%的用户
 * 内存消耗：41.3 MB, 在所有 JavaScript 提交中击败了75.27%的用户
 * 选择排序 找前n个数
 */
var maxProduct = function (nums) {
    for (let i = 0; i < 2; i++) {
        let k = i;
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[k]) {
                k = j;
            }
        }
        [nums[i], nums[k]] = [nums[k], nums[i]];
    }
    return (nums[0] - 1) * (nums[1] - 1);
};