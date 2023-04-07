import java.io.*;
import java.util.*;

public class Main {
    static int N = 1010;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] map = new int[5010];
        while (t-- > 0) {
            int n = in.nextInt();
            boolean flag = false;
            Arrays.fill(map, 0);// 把表清零
            // 打表判断两字符间是否有任意一个字符，若有则满足长度为3的回文子序列
            for (int i = 1; i <= n; i++) {
                int a = in.nextInt();
                if (map[a] == 0) {
                    map[a] = i;
                } else if (i - map[a] >= 2) {
                    flag = true;
                }

            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            // if (check(arr)) {
            // System.out.println("YES");
            // } else {
            // System.out.println("NO");
            // }

        }
        in.close();
    }

    // 用密码脱落那题的dp求最长回文子序列的写法写了一下……结果不用这么麻烦
    // static boolean check(int[] arr) {
    // int len = arr.length;
    // int[][] dp = new int[len + 1][len + 1];
    // for (int i = 1; i <= len; i++) {
    // for (int l = 0; l + i - 1 < len; l++) {
    // int r = l + i - 1;
    // if (i == 1) {
    // dp[l][r] = 1;
    // } else {
    // if (arr[l] == arr[r]) {
    // dp[l][r] = dp[l + 1][r - 1] + 2;
    // } else {
    // dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
    // }
    // }
    // if (dp[l][r] >= 3) {
    // return true;
    // }
    // }
    // }
    // return dp[0][len - 1] >= 3;
    // }
}