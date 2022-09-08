/**
 * @param {number[]} fruits
 * @return {number}
 * 执行用时：68 ms, 在所有 JavaScript 提交中击败了98.96%的用户
 * 内存消耗：50.3 MB, 在所有 JavaScript 提交中击败了56.13%的用户
 */
var totalFruit = function (fruits) {
    let n = fruits.length, ans = 0, count = 0;
    const map = new Array(n).fill(0);
    for (let i = 0, j = 0; i < n; i++) {
        if (map[fruits[i]] === 0)
            count++;
        map[fruits[i]]++;
        while (count > 2) {
            map[fruits[j]]--;
            if (map[fruits[j]] === 0)
                count--;
            j++;
        }
        ans = Math.max(ans, i - j + 1);
    }
    return ans;
};