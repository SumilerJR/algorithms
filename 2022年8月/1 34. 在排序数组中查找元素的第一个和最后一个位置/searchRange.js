/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
    return [binarySearch(nums, target, true), binarySearch(nums, target, false)];
};

var binarySearch = function (nums, target, leftOrRight) {
    let res = -1;
    let left = 0, right = nums.length - 1;
    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] < target)
            left = mid + 1;
        else if (nums[mid] > target)
            right = mid - 1;
        else {
            res = mid;
            if (leftOrRight)
                right = mid - 1;
            else
                left = mid + 1;
        }
    }
    return res;
}
