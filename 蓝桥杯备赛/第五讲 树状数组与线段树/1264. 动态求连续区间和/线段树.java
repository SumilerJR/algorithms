import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;

    static int n, m;
    static int[] w = new int[N];

    static class Node {
        int l;
        int r;
        int sum;

        Node() {

        }

        Node(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }

    static Node[] tr = new Node[N * 4];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < tr.length; i++) {
            tr[i] = new Node();
        }
        String[] data = input.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        m = Integer.valueOf(data[1]);
        data = input.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.valueOf(data[i - 1]);
        }
        build(1, 1, n);
        while (m-- > 0) {
            data = input.readLine().split(" ");
            int k = Integer.valueOf(data[0]);
            int a = Integer.valueOf(data[1]);
            int b = Integer.valueOf(data[2]);
            if (k == 0) {
                output.write(query(1, a, b) + "\n");
            } else {
                modify(1, a, b);
            }
        }
        input.close();
        output.close();
        return;
    }

    public static void pushup(int u) {
        tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
    }

    public static void build(int u, int l, int r) {
        if (l == r) {
            tr[u] = new Node(l, r, w[r]);
        } else {
            tr[u] = new Node(l, r, 0);
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            pushup(u);
        }
    }

    public static int query(int u, int l, int r) throws Exception {
        if (l <= tr[u].l && tr[u].r <= r) {
            return tr[u].sum;
        }
        int mid = tr[u].l + tr[u].r >> 1;
        int sum = 0;
        if (mid >= l) {
            sum += query(u << 1, l, r);
        }
        if (r >= mid + 1) {
            sum += query(u << 1 | 1, l, r);
        }
        return sum;
    }

    public static void modify(int u, int x, int v) {
        if (tr[u].l == tr[u].r) {
            tr[u].sum += v;
        } else {
            int mid = tr[u].l + tr[u].r >> 1;
            if (x <= mid) {
                modify(u << 1, x, v);
            } else {
                modify(u << 1 | 1, x, v);
            }
            pushup(u);
        }
    }

}