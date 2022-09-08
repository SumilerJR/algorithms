/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 * 执行用时：76 ms, 在所有 JavaScript 提交中击败了28.96%的用户
 * 内存消耗：45.4 MB, 在所有 JavaScript 提交中击败了20.95%的用户
 */
var minSubArrayLen = function (target, nums) {
    let n = nums.length;
    let ans = Number.MAX_VALUE, sum = 0;
    for (let left = 0, right = 0; right < n; right++) {
        sum += nums[right];
        while (sum >= target) {
            ans = Math.min(ans, right - left + 1);//先取最小值
            sum -= nums[left++];//再缩左边界
        }
    }
    return ans === Number.MAX_VALUE ? 0 : ans;
};