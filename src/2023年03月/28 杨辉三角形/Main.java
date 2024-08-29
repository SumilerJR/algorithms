import java.util.*;

// 蓝桥云课：https://www.lanqiao.cn/problems/1457/learning/?problem_list_id=2&page=1&sort=students_count
// AcWing：https://www.acwing.com/problem/content/description/3421/
public class Main {
    // static int N = 100010;
    static long n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextLong();
        scan.close();
        // 在此输入您的代码...
        for (int i = 16;; i--) {
            if (check(i))
                break;
        }
        return;
    }

    // 求组合数C^a^~b~
    public static long C(long a, long b) {
        long res = 1;
        for (long i = a, j = 1; j <= b; i--, j++) {
            res = res * i / j;
            if (res > n) {
                break;
            }
        }
        return res;
    }

    public static boolean check(int k) {
        long left = k * 2, right = n;
        while (left < right) {
            long mid = (left + right) >> 1;
            if (C(mid, k) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left > right || C(right, k) != n)
            return false;
        System.out.print(right * (right + 1) / 2 + k + 1);

        return true;
    }
}