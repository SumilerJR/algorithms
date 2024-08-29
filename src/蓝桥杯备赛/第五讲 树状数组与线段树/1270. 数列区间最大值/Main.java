import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;

    static int n, m;
    static int[] w= new int[N];

    static class Node {
        int l, r;
        int maxv = Integer.MIN_VALUE;
        Node() {}
        Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
        Node(int l, int r, int maxv) {
            this.l = l;
            this.r = r;
            this.maxv = maxv;
        }
    }

    static Node[] tr = new Node[N * 4];

    public static void main(String[] args) throws Exception {
        String[] data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        m = Integer.valueOf(data[1]);
        data = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.valueOf(data[i - 1]);
        }
        build(1, 1, n);
        while (m-- > 0) {
            data = in.readLine().split(" ");
            int x = Integer.valueOf(data[0]);
            int y = Integer.valueOf(data[1]);
            out.write(query(1, x, y) + "\n");
        }
        in.close();
        out.close();
    }

    public static void build(int u, int l, int r) {
        if (l == r) tr[u] = new Node(l, r, w[r]);
        else {
            tr[u] = new Node(l, r);
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            tr[u].maxv = Math.max(tr[u << 1].maxv, tr[u << 1 | 1].maxv);
        }
    }

    public static int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].maxv;
        int mid = tr[u].l + tr[u].r >> 1;
        int maxv = Integer.MIN_VALUE;
        if (l <= mid) maxv = query(u << 1, l, r);
        if (r > mid) maxv = Math.max(maxv, query(u << 1 | 1, l, r));
        return maxv;
    }

}