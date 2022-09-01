/**
 * @param {number[]} prices
 * @return {number[]}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了86.36%的用户
 * 内存消耗：42.8 MB, 在所有 JavaScript 提交中击败了69.89%的用户
 */
var finalPrices = function (prices) {
    let len = prices.length;
    const res = new Array(len).fill(0);
    for (let i = 0; i < prices.length; i++) {
        let j = i + 1;
        while (j < prices.length && prices[j] > prices[i]) {
            j++;
        }
        res[i] = j < len ? prices[i] - prices[j] : prices[i];
    }
    return res;
};


// 执行用时：72 ms, 在所有 JavaScript 提交中击败了44.89 % 的用户
// 内存消耗：42.3 MB, 在所有 JavaScript 提交中击败了88.07 % 的用户
var finalPrices = function (prices) {
    let len = prices.length;
    const res = [...prices];
    for (let i = 0; i < prices.length; i++) {
        let j = i + 1;
        while (j < prices.length && prices[j] > prices[i]) {
            j++;
        }
        if (j < len) {
            res[i] -= prices[j];
        }
    }
    return res;
};


/**
 * @param {number[]} prices
 * @return {number[]}
 * 单调栈
 * 执行用时：80 ms, 在所有 JavaScript 提交中击败了15.34%的用户
 * 内存消耗：43 MB, 在所有 JavaScript 提交中击败了37.50%的用户
 */
var finalPrices = function (prices) {
    const stack = [];
    const len = prices.length;
    const res = new Array(len).fill(0);
    for (let i = 0; i < len; i++) {
        while (stack.length > 0 && prices[stack[0]] >= prices[i]) {
            let index = stack.shift();
            res[index] = prices[index] - prices[i];
        }
        stack.unshift(i);
        res[i] = prices[i];
    }
    return res;
};