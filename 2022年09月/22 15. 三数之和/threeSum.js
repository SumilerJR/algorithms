/**
 * @param {number[]} nums
 * @return {number[][]}
 * 执行用时：120 ms, 在所有 JavaScript 提交中击败了79.56%的用户
 * 内存消耗：51.8 MB, 在所有 JavaScript 提交中击败了40.92%的用户
 */
var threeSum = function (nums) {
    let res = [], n = nums.length;
    if (n < 3)
        return [];
    nums.sort((a, b) => {
        return a - b;
    });
    if (nums[0] > 0 || nums[n - 1] < 0)
        return [];
    for (let i = 0; i < n - 2; i++) {
        if (nums[i] > 0)
            break;
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        let left = i + 1, right = n - 1;
        while (left < right) {
            let sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                res.push([nums[i], nums[left], nums[right]]);
                while (left < right && nums[left++] == nums[left]);//跳过重复的值
                while (left < right && nums[right--] == nums[right]);
            }
        }
    }
    return res;
};