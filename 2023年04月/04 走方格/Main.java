import java.io.*;
import java.util.*;

// 2067. 走方格 - AcWing题库
// https://www.acwing.com/problem/content/2069/
public class Main {

    static int count = 0;
    static int n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        if (!(n % 2 == 0 && m % 2 == 0))
            dfs(1, 1);
        System.out.println(count);
        in.close();
    }

    public static void dfs(int x, int y) {
        if (x < 0 || x > n || y < 0 || y > m)
            return;

        if (x % 2 == 0 && y % 2 == 0)
            return;
        if (x == n && y == m) {
            count++;
            return;
        }
        dfs(x + 1, y);
        dfs(x, y + 1);
    }
}