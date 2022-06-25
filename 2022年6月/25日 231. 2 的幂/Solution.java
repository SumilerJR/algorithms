// 一个数 nn 是 22 的幂，当且仅当 nn 是正整数，并且 nn 的二进制表示中仅包含 11 个 11。
// 使用位运算，将 nn 的二进制表示中最低位的那个 11 提取出来，再判断剩余的数值是否为 00 即可。

//第一个技巧是  n & (n - 1)
// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：38.6 MB, 在所有 Java 提交中击败了53.15%的用户
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}


//第二个技巧是  n & (-n)
// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：38.6 MB, 在所有 Java 提交中击败了57.88%的用户
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
}

// - 判断是否为最大 2 的幂的约数
//在题目给定的32位有符号整数的范围内，最大的2的幂为 2^{30} = 10737418242 的约数即可。

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/power-of-two/solution/2de-mi-by-leetcode-solution-rny3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：38.3 MB, 在所有 Java 提交中击败了93.56%的用户
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((1 << 30) % n) == 0;
    }
}

// - 暴力递归
// 打草稿很快理解了这题想考什么，看二进制位里是不是只有一个1即可
// 但对位运算不是很熟练，摸索了一番就想到可以不断除以2来得到，写的时候真的没觉得有问题！！！写完看答案才发现这tm不就是最sb的写法吗！！！我是傻逼！
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        if (n % 2 != 0 || n == 0)
            return false;
        return isPowerOfTwo(n / 2);
    }
}
