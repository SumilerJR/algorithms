/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function (nums1, nums2) {
    const map = new Map();
    let intersect = [];
    for (let i of nums1) {
        if (map.has(i))
            map.set(i, map.get(i) + 1);
        else
            map.set(i, 1);
    }
    for (let i of nums2) {
        if (map.has(i) && map.get(i) > 0) {
            intersect.push(i);
            map.set(i, map.get(i) - 1);
        }
    }
    return intersect;
};

// 执行用时：60 ms, 在所有 JavaScript 提交中击败了87.59%的用户
// 内存消耗：41.2 MB, 在所有 JavaScript 提交中击败了95.96 % 的用户
// - 写成双层for循环的形式
var intersect = function (nums1, nums2) {
    const res = [];
    for (let i = 0; i < nums1.length; i++) {
        for (let j = 0; j < nums2.length; j++) {
            if (nums1[i] === nums2[j]) {
                res.push(nums1[i]);
                nums2[j] = null;
                break;
            }
        }
    }
    return res;
};

// 执行用时：68 ms, 在所有 JavaScript 提交中击败了50.54%的用户
// 内存消耗：41.5 MB, 在所有 JavaScript 提交中击败了83.91 % 的用户
// - 箭头函数 + 遍历挑元素
var intersect = function (nums1, nums2) {
    const res = []
    nums2.forEach((item) => {
        const index = nums1.indexOf(item)
        if (index !== -1) {
            res.push(item);
            nums1[index] = null;
        }
    })
    return res;
};
