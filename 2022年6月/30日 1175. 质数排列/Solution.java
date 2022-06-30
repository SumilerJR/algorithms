// - 计算n以内的质数个数a，然后计算a! * (n-a)!即可 复习了一遍质数的求法……
// 值得注意的是阶乘太大 需要long来计算
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：38.4 MB, 在所有 Java 提交中击败了43.31%的用户
class Solution {
    int MOD = (int)1e9+7;
    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++)
        {
            int j = 2;
            for (; j * j <= i; j++)
                if (i % j == 0) {
                    break;
                }
            if (j * j > i)
                count++;
        }
        return (int) (factorial(count) * factorial(n - count) % MOD);
    }
    public long factorial (int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1) % MOD;
    }
}
