/**
 * @param {string} s
 * @return {string}
 * 执行用时：80 ms, 在所有 JavaScript 提交中击败了14.15%的用户
 * 内存消耗：46 MB, 在所有 JavaScript 提交中击败了5.00%的用户
 */
var reverseWords = function (s) {

    let n = s.length;
    let left = 0, right = n - 1;
    while (s[left] === ' ') {
        left++;
    }
    while (s[right] === ' ') {
        right--;
    }
    const arr = [];
    while (left <= right) {
        if (s[left] !== ' ' || arr[arr.length - 1] !== ' ') {
            arr.push(s[left]);
        }
        left++;
    }
    reverseString(arr, 0, arr.length - 1);
    for (let i = 0, j = 1; i < arr.length; j++) {
        while (j < arr.length && arr[j] !== ' ') {
            j++;
        }
        reverseString(arr, i, j - 1);
        i = j + 1;
        j = i;
    }
    return arr.join('');
};

var reverseString = function (arr, left, right) {
    while (left < right) {
        [arr[left], arr[right]] = [arr[right], arr[left]];
        left++;
        right--;
    }
};