import java.io.*;
import java.util.*;
public class Main {
    static int N = 32010;
    static int n;
    static int[] tree = new int[N];
    static int[] level = new int[N];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            int x = Integer.valueOf(data[0]);
            int y = Integer.valueOf(data[1]);
            x++;
            level[sum(x)]++;
            add(x);
        }
        for (int i = 0; i < n; i++) {
            bw.write(level[i] + "\n");
            // System.out.println(level[i]);
        }

        br.close();
        bw.close();
        return;
    }

    public static int lowbit(int x) {
        return x & -x;
    }

    public static void add(int x) {
        for (int i = x; i < N; i += lowbit(i)) {
            tree[i]++;
        }
    }

    public static int sum(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tree[i];
        }
        return res;
    }


}