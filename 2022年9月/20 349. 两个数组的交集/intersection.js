/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了36.36%的用户
 * 内存消耗：42.9 MB, 在所有 JavaScript 提交中击败了16.60%的用户
 */
var intersection = function (nums1, nums2) {
    const set = new Set();
    for (let num of nums1) {
        set.add(num);
    }
    const res = new Set();
    for (let num of nums2) {
        if (set.has(num)) {
            res.add(num);
        }
    }
    return Array.from(res);
};