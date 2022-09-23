/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 * 执行用时：60 ms, 在所有 JavaScript 提交中击败了87.43%的用户
 * 内存消耗：43.6 MB, 在所有 JavaScript 提交中击败了68.15%的用户
 * 注意！这里给的是s是字符串，若要传值进行函数调用，需要转为数组！
 */
var reverseStr = function (s, k) {
    const n = s.length;
    const arr = s.split('');
    for (let i = 0; i < n; i += (2 * k)) {
        if (i + k < n) {
            reverser(arr, i, i + k - 1);
        } else {
            reverser(arr, i, n - 1);
        }
    }
    return arr.join('');
};
var reverser = function (arr, left, right) {
    while (left < right) {
        [arr[left++], arr[right--]] = [arr[right], arr[left]];
    }
};
