import java.io.*;
import java.util.*;

// 2553. 最优包含 - AcWing题库
// https://www.acwing.com/problem/content/description/2555/
public class Main {
    static int N = 1010;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        char[] t = in.next().toCharArray();
        int len1 = s.length, len2 = t.length;
        /*
         * dp这个二维数组中，竖列代表s1,横列代表s2,s2比s1短，到后面会有很多空串，
         * 无论怎么修改都不会使空串变长，故先全部初始化为无穷；
         * 与之区别。s1先全部初始化为0
         * 注意代码 先后顺序 ，要保证dp[0][0]=0
         */
        int[][] dp = new int[N][N];
        for (int j = 0; j <= len2; j++)
            dp[0][j] = 100000;
        for (int i = 0; i <= len1; i++)
            dp[i][0] = 0;
        // 查改过程
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = dp[i - 1][j];// 如果s1的前i - 1个包括s2的前j个，那么s1的前i个至少也包括s2的前j个
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(dp[len1][len2]);
        in.close();
    }
}