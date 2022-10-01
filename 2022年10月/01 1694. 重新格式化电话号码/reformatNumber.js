/**
 * @param {string} number
 * @return {string}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了25.71%的用户
 * 内存消耗：42.6 MB, 在所有 JavaScript 提交中击败了5.71%的用户
 */
var reformatNumber = function (number) {
    let arr = [];
    for (let i = 0; i < number.length; i++) {
        if (Number.isInteger(Number.parseInt(number[i]))) {
            arr.push(number[i]);
        }
    }
    let res = [];
    let n = arr.length;
    while (n > 4) {
        res.push(arr.shift(), arr.shift(), arr.shift(), '-');
        n -= 3;
    }
    if (n === 4) {
        res.push(arr.shift(), arr.shift(), '-', arr.shift(), arr.shift());
    } else {
        res.push(arr.shift(), arr.shift(), arr.shift());
    }
    return res.join('');
};
