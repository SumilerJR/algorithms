/**
 * @param {number[]} groupSizes
 * @return {number[][]}
 * 执行用时：96 ms, 在所有 JavaScript 提交中击败了14.58%的用户
 * 内存消耗：47.4 MB, 在所有 JavaScript 提交中击败了12.50%的用户
 */
 var groupThePeople = function (groupSizes) {
    const res = [];
    const map = new Array(groupSizes.length + 1).fill([]).map(() => new Array(0));
    for (let i in groupSizes) {
        map[groupSizes[i]].push(i);
        if (map[groupSizes[i]].length === groupSizes[i]) {
            res.push(map[groupSizes[i]]);
            map[groupSizes[i]] = [];
        }
        console.log(map);
    }
    return res;
};