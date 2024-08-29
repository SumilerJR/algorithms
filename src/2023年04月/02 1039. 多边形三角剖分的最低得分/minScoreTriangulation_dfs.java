import java.util.Arrays;

class Solution {
    int[] v;
    int[][] memory;// 需要记忆化搜索，否则超时了（当dfs超时时可以考虑一下这个

    public int minScoreTriangulation(int[] values) {
        this.v = values;
        int len = v.length;
        this.memory = new int[len][len];
        return dfs(0, len - 1);
    }

    public int dfs(int left, int right) {
        if (right == left + 1)
            return 0;
        if (memory[left][right] != 0)
            return memory[left][right];
        int res = Integer.MAX_VALUE;
        for (int mid = left + 1; mid < right; mid++) {
            res = Math.min(res, dfs(left, mid) + dfs(mid, right) + v[left] * v[mid] * v[right]);
        }
        memory[left][right] = res;
        return res;
    }
}