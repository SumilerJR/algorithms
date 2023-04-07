import java.util.*;

// 3490. 小平方 - AcWing题库
// https://www.acwing.com/problem/content/3493/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        int half = (n + 1) / 2;// 要向上取整，或者直接左边乘以2来代替右边除以2
        for (int i = 1; i < n; i++) {
            if ((i * i) % n * 2 < n) {
                ans++;
            }
        }
        System.out.println(ans);
        in.close();
    }

    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // int n = in.nextInt();
    // int ans = 0;
    // int half = (n + 1) / 2;
    // for (int i = 1; i < n; i++) {
    // if ((i * i) % n < half) {
    // ans++;
    // }
    // }
    // System.out.println(ans);
    // in.close();
    // }
}
