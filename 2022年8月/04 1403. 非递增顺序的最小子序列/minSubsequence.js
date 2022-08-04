/**
 * @param {number[]} nums
 * @return {number[]}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了81.43%的用户
 * 内存消耗：43.3 MB, 在所有 JavaScript 提交中击败了77.14%的用户
 */
 var minSubsequence = function(nums) {
    nums.sort((a, b) => b - a);
    let sum = 0;
    let resultSum = 0;
    const length = nums.length;
    const result = [];
    for (let i = 0; i < length; i++) {
        sum += nums[i];
    }
    for (let i = 0; resultSum <= sum && i < length; i++) {
        result.push(nums[i]);
        resultSum += nums[i];
        sum -= nums[i];
    }
    return result;
};