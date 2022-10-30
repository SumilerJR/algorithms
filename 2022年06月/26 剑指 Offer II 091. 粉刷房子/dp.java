// - 常规的动态规划……
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：40.7 MB, 在所有 Java 提交中击败了74.26%的用户
class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        for (int i = 1; i < len; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[len - 1][0], Math.min(costs[len - 1][1], costs[len - 1][2]));
    }
}
