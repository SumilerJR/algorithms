import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        // int[][] arr = new int[n + 1][m + 1];
        int[][] preSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int temp = sc.nextInt();
                preSum[i][j] = temp + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j -  1];
            }
        }
        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();
            // System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            //这里要减去的是[x1 - 1][y2]和[x2][y1 - 1],减齐了！，最后把减了两次的加回去[x1 - 1][y1 - 1]
            int ans = preSum[x2][y2] + preSum[x1 - 1][y1 - 1] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1];
            System.out.println(ans);
        }
    }
}
