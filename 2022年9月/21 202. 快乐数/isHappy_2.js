/**
 * @param {number} n
 * @return {boolean}
 * 执行用时：76 ms, 在所有 JavaScript 提交中击败了19.05%的用户
 * 内存消耗：41.2 MB, 在所有 JavaScript 提交中击败了94.61%的用户
 */
// 方法：
// 使用 “快慢指针” 思想，找出循环：“快指针” 每次走两步，“慢指针” 每次走一步，当二者相等时，即为一个循环周期。此时，判断是不是因为 1 引起的循环，是的话就是快乐数，否则不是快乐数。
// 注意：此题不建议用集合记录每次的计算结果来判断是否进入循环，因为这个集合可能大到无法存储；另外，也不建议使用递归，同理，如果递归层次较深，会直接导致调用栈崩溃。不要因为这个题目给出的整数是 int 型而投机取巧。

// 作者：linux - man;
// 链接：https://leetcode.cn/problems/happy-number/solution/shi-yong-kuai-man-zhi-zhen-si-xiang-zhao-chu-xun-h/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
var bitSquareSum = function (n) {
    let sum = 0;
    while (n) {
        sum += (n % 10) ** 2;
        n = Math.floor(n / 10);
    }
    return sum;
};
var isHappy = function (n) {
    let slow = n, fast = n;
    do {
        slow = bitSquareSum(slow);
        fast = bitSquareSum(bitSquareSum(fast));
    } while (slow !== fast);
    return slow === 1;
};
