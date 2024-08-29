/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 * 执行用时：84 ms, 在所有 JavaScript 提交中击败了6.62%的用户
 * 内存消耗：41.4 MB, 在所有 JavaScript 提交中击败了65.70%的用户
 */
var backspaceCompare = function (s, t) {
    let n1 = n2 = 0;
    let i = s.length - 1;
    let j = t.length - 1;
    while (true) {
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                n1++;
            } else {
                if (n1 > 0) {
                    n1--;
                } else {
                    break;
                }
            }
            i--;
        }
        while (j >= 0) {
            if (t.charAt(j) == '#') {
                n2++;
            } else {
                if (n2 > 0) {
                    n2--;
                } else {
                    break;
                }
            }
            j--;
        }
        // 后半部分#消除完了，接下来比较S[i] != T[j]
        if (i < 0 || j < 0) break; // S 或者T 遍历到头了
        if (s[i] != t[j]) return false;
        i--; j--;
    }
    if (i == -1 && j == -1) return true;
    return false;

};
