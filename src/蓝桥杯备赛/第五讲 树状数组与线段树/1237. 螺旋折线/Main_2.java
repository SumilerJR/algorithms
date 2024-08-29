import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(), y = in.nextInt();
        long ans = 0;
        long n = Math.max(Math.abs(x), Math.abs(y));// 层数
        if (x > y) {
            // 斜线右下方，(2n)^2 加上 (x, y) 到 (n, n)的曼哈顿距离
            ans = (2 * n) * (2 * n) + (n - x) + (n - y);
        } else {
            // 斜线左上方，(2n)^2 减去 (x, y) 到 (n, n)的曼哈顿距离
            ans = (2 * n) * (2 * n) - (n - x) - (n - y);
        }
        System.out.print(ans);
        in.close();
        return;
    }
}
