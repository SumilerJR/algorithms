class Solution {
    // 好久没写回溯，写的好low！
    int ans = 0;
    int n = 0;

    public int countVowelStrings(int n) {
        this.n = n;
        dfs(0, 1);// 这里从第0位开始就不用手动循环一次啦……（在dfs里去循环）
        return ans;
    }

    public void dfs(int i, int j) {
        if (i > n || j > 5)
            return;
        else if (i == n)
            ans++;
        else {
            for (int k = j; k <= 5; k++) {
                dfs(i + 1, k);
            }
        }
    }
}