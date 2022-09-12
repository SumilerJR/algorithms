/**
 * @param {number} n
 * @return {number[][]}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了43.51%的用户
 * 内存消耗：41.1 MB, 在所有 JavaScript 提交中击败了67.91%的用户
 */
var generateMatrix = function (n) {
    const arr = new Array(n).fill(0).map(() => new Array(n).fill(0));
    const m = Math.floor(n / 2);
    let i = 0, j = 0, k = 1;//定义i为第几轮螺旋，j为下标运算，k为当前自增数字
    // 关键点：找到对应的上下界，如可以只用i做下界，而通过n和j预算得出上界
    while (i < m) {
        for (j = i; j < n - i - 1; j++) {
            arr[i][j] = k++;//第i轮则在第i列开始从左往右，上界为n-i-1
        }
        for (j = i; j < n - i - 1; j++) {
            arr[j][n - i - 1] = k++;//从上往下，下界为i，上界为n-i-1
        }
        for (j = n - i - 1; j > i; j--) {
            arr[n - i - 1][j] = k++;//从右往左，下界为n-i-1，上界为i(反过来)
        }
        for (j = n - i - 1; j > i; j--) {
            arr[j][i] = k++;//从下往上，下界为n-i-1，上界为i(反过来)
        }
        i++;
        j++;
    }
    if (n % 2 == 1) {
        arr[i][j] = k;
    }
    return arr;
};
