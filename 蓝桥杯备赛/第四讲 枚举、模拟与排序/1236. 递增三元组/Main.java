import java.util.*;
public class Main {
    static int N = 100005;
    static int n;
    static int[] a, b, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[N];
        b = new int[N];
        c = new int[N];
        int[] sumA = new int[N];//表示在A中有多少个数小于B[i]
        int[] sumC = new int[N];//表示在C中有多少个数大于B[i]

        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
            sumA[a[i]]++;
        }
        for (int i = 0; i < n; ++i) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            c[i] = sc.nextInt();
            sumC[c[i]]++;
        }


        for (int i = 1; i < N; ++i) {
            sumA[i] += sumA[i - 1];
            sumC[i] += sumC[i - 1];
        }

        long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (b[i] == 0) continue;
            ans += (long) sumA[b[i] - 1] * (sumC[N - 1] - sumC[b[i]]);
        }
        System.out.print(ans);
    }
}