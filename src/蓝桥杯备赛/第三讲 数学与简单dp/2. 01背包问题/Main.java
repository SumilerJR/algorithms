import java.util.*;
public class Main {
    static int MAX = 1010;
    static int[] v = new int[MAX];
    static int[] w = new int[MAX];
    static int[][] dp = new int[MAX][MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//物品数量
        int m = sc.nextInt();//背包容量
        // int[][] arr = new int[n][2];

        for (int i  = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < v[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.print(dp[n][m]);

    }
}