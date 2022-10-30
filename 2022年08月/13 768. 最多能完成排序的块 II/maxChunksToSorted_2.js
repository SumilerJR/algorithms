/**
 * @param {number[]} arr
 * @return {number}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了53.33%的用户
 * 内存消耗：42.9 MB, 在所有 JavaScript 提交中击败了60.00%的用户
 * 单调栈：https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/solution/zui-duo-neng-wan-cheng-pai-xu-de-kuai-ii-deng-jie-/
 */
var maxChunksToSorted = function (arr) {
    const stack = [];
    let ans = 0;
    for (let i = 0; i < arr.length; i++) {
        if (stack.length !== 0 && arr[i] < stack[stack.length - 1]) {
            let head = stack.pop();
            while (stack.length !== 0 && arr[i] < stack[stack.length - 1]) {
                stack.pop();
            }
            stack.push(head);
        } else {
            stack.push(arr[i]);
        }
    }
    return stack.length;
};