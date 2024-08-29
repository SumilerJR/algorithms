import java.io.*;
import java.util.*;
public class Main {
    static int N = 100010;
    static int n, m;
    static int[] a, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        m = Integer.valueOf(data[1]);
        a = new int[N];
        tree = new int[N];
        data = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.valueOf(data[i - 1]);
            add(i, a[i] );
        }
        for (int i = 0; i < m; i++) {
            data = br.readLine().split(" ");
            int k = Integer.valueOf(data[0]);
            int x = Integer.valueOf(data[1]);
            int y = Integer.valueOf(data[2]);
            if (k == 0) {
                System.out.println(query(y) - query(x - 1));
            } else {
                add(x, y);
            }
        }
        return;
    }

    public static int lowbit(int x) {
        return x & -x;
    }

    public static void add(int x, int v) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += v;
        }
    }

    public static int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tree[i];
        }
        return res;
    }
}