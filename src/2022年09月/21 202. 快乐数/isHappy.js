/**
 * @param {number} n
 * @return {boolean}
 * 执行用时：76 ms, 在所有 JavaScript 提交中击败了19.05%的用户
 * 内存消耗：42.8 MB, 在所有 JavaScript 提交中击败了38.50%的用户
 */
var isHappy = function (n) {
    const set = new Set();
    while (true) {
        let temp = 0;
        while (n) {
            temp += (n % 10) ** 2;
            n = Math.floor(n / 10);//记得手动向下取整
        }
        if (temp === 1) {
            return true;
        } else if (set.has(temp)) {
            return false;
        } else {
            set.add(temp);
        }
        n = temp;
    }
};