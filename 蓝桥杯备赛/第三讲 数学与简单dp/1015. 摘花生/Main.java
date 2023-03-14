import java.util.*;
public class Main {
    static int t;
    // static int r;
    // static int c;
    // static int[] m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int k = 0; k < t; ++k) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] m = new int[r + 1][c + 1];
            for (int i = 1; i <= r; ++i) {
                for (int j = 1; j <= c; ++j) {
                    m[i][j] = sc.nextInt();
                }
            }
            int[][] dp = new int[r + 1][c + 1];
            for (int i = 1; i <= r; ++i) {
                for (int j = 1; j <= c; ++j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
                }
            }
            System.out.println(dp[r][c]);
        }

    }
}