/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了71.26%的用户
 * 内存消耗：43 MB, 在所有 JavaScript 提交中击败了29.53%的用户
 */
var intersect = function (nums1, nums2) {
    const map = new Array(1000).fill(0);
    const res = [];
    for (let num of nums1) {
        map[num]++;
    }
    for (let num of nums2) {
        if (map[num] !== 0) {
            res.push(num);
            map[num]--;
        }
    }
    return res;
};