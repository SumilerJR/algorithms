/**
 * @param {string} s
 * @return {string}
 * 执行用时：52 ms, 在所有 JavaScript 提交中击败了93.52%的用户
 * 内存消耗：40.7 MB, 在所有 JavaScript 提交中击败了92.63%的用户
 */
var replaceSpace = function (s) {
    return s.replaceAll(' ', '%20');
};



var replaceSpace = function (s) {
    const arr = Array.from(s);
    let count = 0, n = arr.length;
    for (let i = 0; i < n; i++) {
        if (arr[i] === ' ') {
            count++;
        }
    }
    let left = n - 1;
    let right = n + count * 2 - 1;
    while (left >= 0) {
        if (arr[left] === ' ') {
            arr[right--] = '0';
            arr[right--] = '2';
            arr[right--] = '%';
            left--;
        } else {
            arr[right--] = arr[left--];
        }
    }
    return arr.join('');
};