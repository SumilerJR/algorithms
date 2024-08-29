import java.io.*;
import java.util.*;

// 任意两天之间的买卖，都可以细化为期间两天之间，所有卖出大于买入的累计
public class Main {
    static int N = 100010;
    static int n;
    static int[] stock = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            stock[i] = in.nextInt();
        }
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (stock[i] > stock[i - 1]) {
                ans += stock[i] - stock[i - 1];
            }
        }
        System.out.println(ans);
    }
}