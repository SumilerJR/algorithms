import java.util.*;

public class Main {
    static int N = 510;

    // 暴力只能过一半样例
    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
    // long[][] map = new long[N][N];
    // long ans = 0;
    // for (int i = 1; i <= n; i++) {
    // for (int j = 1; j <= m; j++) {
    // int a = in.nextInt();
    // map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + a;// 前缀和
    // // System.out.println(map[i][j]);
    // }
    // }
    // for (int i = 1; i <= n; i++) {
    // for (int j = 1; j <= m; j++) {
    // for (int x = 1; x <= i; x++) {
    // for (int y = 1; y <= j; y++) {
    // long a = map[i][j] - map[i - x][j] - map[i][j - y] + map[i - x][j - y];
    // if (a <= k) {
    // ans++;
    // }
    // }
    // }
    // }
    // }
    // System.out.println(ans);
    // in.close();
    // }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        long[][] map = new long[N][N];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = in.nextLong() + map[i - 1][j];// 一维前缀和
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int l = 1, r = 1, sum = 0; r <= m; r++) {
                    sum += map[j][r] - map[i - 1][r];
                    while (sum > k) {
                        sum -= map[j][l] - map[i - 1][l];
                        l++;
                    }
                    ans += r - l + 1;
                }
            }
        }
        System.out.println(ans);
        in.close();
    }
}