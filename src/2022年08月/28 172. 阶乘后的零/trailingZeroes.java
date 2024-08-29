//执行用时：3 ms, 在所有 Java 提交中击败了28.79%的用户
//内存消耗：38.8 MB, 在所有 Java 提交中击败了18.66%的用户
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int j = i; j % 5 == 0; j /= 5) {
                count++;
            }
        }
        return count;
    }
}