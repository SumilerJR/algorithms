import java.util.*;

public class Main {
    static int N = 1000010;
    static int[] h = new int[N];
    static int[] tr = new int[N];
    static int[] sum = new int[N];
    static int n;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt() + 1;
        }
        // 求每个数前面有多少个数比它大
        for (int i = 0; i < n; i++) {
            sum[i] += query(N - 1) - query(h[i]);
            add(h[i], 1);
        }
        // 求每个数后面有多少个数比它大
        Arrays.fill(tr, 0);
        for (int i = n - 1; i >= 0; i--) {
            sum[i] += query(h[i] - 1);
            add(h[i], 1);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            // 这里会爆int，所以应该是先转long再除以2
            // ans += (long) ((sum[i] * (sum[i] + 1)) / 2);//×
            // ans += (1L * sum[i] * (sum[i] + 1)) / 2;//√
            ans += ((long) sum[i] * ((long) sum[i] + 1)) / 2;// √
        }
        System.out.print(ans);
        in.close();
    }

    public static int lowbit(int x) {
        return x & -x;
    }

    public static void add(int x, int v) {
        for (int i = x; i < N; i += lowbit(i)) {
            tr[i] += v;
        }
    }

    public static int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tr[i];
        }
        return res;
    }

}