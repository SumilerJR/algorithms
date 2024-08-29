/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 * 执行用时：100 ms, 在所有 JavaScript 提交中击败了39.36%的用户
 * 内存消耗：43.1 MB, 在所有 JavaScript 提交中击败了79.68%的用户
 */
var minWindow = function (s, t) {
    const n = s.length;
    const map = {};
    let missingType = 0, minLen = Number.MAX_VALUE, ansLeft = n;
    for (let ch of t) {
        if (!map[ch]) {
            map[ch] = 1;
            missingType++;
        } else {
            map[ch]++;
        }
    }
    for (let left = 0, right = 0; right < n; right++) {
        if (map[s[right]] !== undefined) {
            map[s[right]]--;
        }
        if (map[s[right]] === 0) {
            missingType--;
        }
        while (missingType === 0) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                ansLeft = left
            }
            if (map[s[left]] !== undefined) {
                map[s[left]]++;
            }
            if (map[s[left]] > 0) {
                missingType++;
            }
            left++;
        }
    }
    return minLen == Number.MAX_VALUE ? "" : s.substring(ansLeft, ansLeft + minLen);
};