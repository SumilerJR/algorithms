/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number[]} nums3
 * @param {number[]} nums4
 * @return {number}
 * 执行用时：196 ms, 在所有 JavaScript 提交中击败了51.27%的用户
 * 内存消耗：44.6 MB, 在所有 JavaScript 提交中击败了80.06%的用户
 */
var fourSumCount = function (nums1, nums2, nums3, nums4) {
    let ans = 0, n = nums1.length;
    const map = new Map();
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            let sum = nums1[i] + nums2[j];
            map.set(sum, (map.get(sum) || 0) + 1);
        }
    }
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            let sum = (nums3[i] + nums4[j]);
            if (map.has(-sum)) {
                ans += map.get(-sum);
            }
        }
    }
    return ans;
};