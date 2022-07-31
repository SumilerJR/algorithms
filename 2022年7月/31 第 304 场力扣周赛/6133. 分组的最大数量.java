// 执行用时：28 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：49.3 MB, 在所有 Java 提交中击败了100.00%的用户
// 模拟
class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int max = 1, pre = 1;
        for (int i = 1; i < grades.length;) {
            int count = 0;
            while (i < grades.length && count <= pre) {
                i++;
                count++;
            }
            if (i <= grades.length && count > pre) {
                pre = count;
                max++;
            }
            else
                break;
        }
        return max;
    }
}
// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：49.5 MB, 在所有 Java 提交中击败了100.00%的用户
// 数学
class Solution {
    public int maximumGroups(int[] grades) {
        int count = 1;
        for (int i = 1; (1 + i) * i <= 2 * grades.length; i++)
            count = i;
        return count;
    }
}
