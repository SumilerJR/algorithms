/**
 * @param {string} equation
 * @return {string}
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了42.31%的用户
 * 内存消耗：41.1 MB, 在所有 JavaScript 提交中击败了73.08%的用户
 */
var solveEquation = function (equation) {
    // equation = equation.replaceAll('-', '+-');
    const arr = equation.replaceAll('-', '+-').split('=');
    const left = arr[0].split('+');
    const right = arr[1].split('+');
    let x = 0, sum = 0;
    for (let i of left) {
        if (i.includes('x')) {
            if ('x' === i) {
                x += 1;
            }
            else if ('-x' === i) {
                x -= 1;
            }
            else {
                x += Number.parseInt(i.substring(0, i.length - 1));
            }
        }
        else if (i !== '') {
            sum -= Number.parseInt(i);
        }
    }
    for (let i of right) {
        if (i.includes('x')) {
            if ('x' === i) {
                x -= 1;
            }
            else if ('-x' === i) {
                x += 1;
            }
            else {
                x -= Number.parseInt(i.substring(0, i.length - 1));
            }
        }
        else if (i !== '') {
            sum += Number.parseInt(i);
        }
    }
    if (x === 0) {
        if (sum === 0)
            return 'Infinite solutions';
        else
            return 'No solution';
    }
    else {
        return 'x=' + sum / x;
    }
};