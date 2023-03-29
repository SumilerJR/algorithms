import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(), y = in.nextInt();
        long ans = 0;
        if (Math.abs(x) <= y) {// 上边
            int n = y;
            ans = (long) (2 * n - 1) * (2 * n) + x - (-n);
        } else if (Math.abs(y) <= x) {// 右边
            int n = x;
            ans = (long) (2 * n) * (2 * n) + n - y;
        } else if (Math.abs(x) <= Math.abs(y) + 1 && y < 0) {// 下边
            int n = Math.abs(y);
            ans = (long) (2 * n) * (2 * n + 1) + n - x;
        } else {
            int n = Math.abs(x);
            ans = (long) (2 * n - 1) * (2 * n - 1) + y - (-n + 1);
        }
        System.out.print(ans);
        in.close();
        return;
    }
}
