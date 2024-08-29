import java.io.*;
import java.util.*;

// 1222. 密码脱落-AcWing题库 https://www.acwing.com/problem/content/description/1224/
public class Main {
    static int N = 1010;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        int n = s.length;
        // 对于一串回文串来说，加上几个字符使它变成回文串和减去几个字符让他变成回文串是等效的，因此这里把问题转化为求去掉几个字符后，能使其变成回文串。
        // 再继续转换，我们可以求出该字符的最长回文子序列，然后用字符串长度减去子序列的长度，即可得到需要去掉的字符数量。
        // 定义dp[l][r]为字符串l到r的最长回文子序列长度
        int[][] dp = new int[N][N];
        // 从长度为1开始枚举，一直到整个字符串
        for (int len = 1; len <= n; len++) {
            // l从0开始，r为l+len-1，定义好左右边界（做到不重不漏）
            // 有一些定义好一个窗口然后滑动的感觉。
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                if (len == 1) {
                    dp[l][r] = 1;// 一个字符本身是回文串
                } else {
                    // 当左右两边字符相同时，那么当前状态为里面状态+2
                    if (s[l] == s[r]) {
                        dp[l][r] = dp[l + 1][r - 1] + 2;
                    }
                    // 其他情况是左右不相等，此时有三种状态：去掉左边、去掉右边、左右都去掉
                    // 那么就取其中长度较大状态
                    if (dp[l][r - 1] > dp[l][r]) {
                        dp[l][r] = dp[l][r - 1];
                    }
                    if (dp[l + 1][r] > dp[l][r]) {
                        dp[l][r] = dp[l + 1][r];
                    }
                }
            }
        }
        // 最终dp[0][n - 1]为整个字符串的最长回文子序列长度
        System.out.println(n - dp[0][n - 1]);
        in.close();
    }
}