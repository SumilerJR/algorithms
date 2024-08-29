/**
 * @param {string} s
 * @return {string}
 * 执行用时：88 ms, 在所有 JavaScript 提交中击败了13.68%的用户
 * 内存消耗：45.5 MB, 在所有 JavaScript 提交中击败了43.16%的用户
 */
var reformat = function (s) {
    var arr1 = [], arr2 = [];
    for (var ch of s) {
        if (Number.isInteger(Number.parseInt(ch)))
            arr1.push(ch);
        else
            arr2.push(ch);
    }
    if (Math.abs(arr1.length - arr2.length) > 1)
        return '';
    if (arr1.length >= arr2.length)
        return fill(arr1, arr2);
    else
        return fill(arr2, arr1);
};

var fill = function (arr1, arr2) {
    const res = [];
    for (let i = 0; i < arr2.length; i++) {
        res.push(arr1[i]);
        res.push(arr2[i]);
    }
    if (arr1.length != arr2.length)
        res.push(arr1[arr1.length - 1]);
    return res.join('');
}


// 双指针
// 执行用时：72 ms, 在所有 JavaScript 提交中击败了58.95 % 的用户
// 内存消耗：43.5 MB, 在所有 JavaScript 提交中击败了95.79 % 的用户
var reformat = function (s) {
    let sumDigit = 0;
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (isDigit(c)) {
            sumDigit++;
        }
    }
    let sumAlpha = s.length - sumDigit;
    if (Math.abs(sumDigit - sumAlpha) > 1) {
        return "";
    }
    let flag = sumDigit > sumAlpha;
    const arr = [...s];
    for (let i = 0, j = 1; i < s.length; i += 2) {
        if (isDigit(arr[i]) !== flag) {
            while (isDigit(arr[j]) !== flag) {
                j += 2;
            }
            [arr[i], arr[j]] = [arr[j], arr[i]];
        }
    }
    return arr.join('');
}

const isDigit = (ch) => {
    return Number.isInteger(Number.parseInt(ch));
}