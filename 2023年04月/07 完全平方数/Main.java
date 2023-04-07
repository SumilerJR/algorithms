import java.util.*;

// 每个合数都可以写成几个质数相乘的形式，其中每个质数都是这个合数的因数，把一个合数用质因数相乘的形式表示出来，叫做分解质因数。如30=2×3×5 。分解质因数只针对合数。
// 通过了 8/11个数据
public class Main {
    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // long n = in.nextLong();
    // for (long i = 1; i <= 1e12; i++) {
    // if ((i * i) % n == 0) {
    // System.out.println((i * i) / n);
    // break;
    // }
    // }
    // in.close();
    // }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long res = 1;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    s++;
                    n /= i;
                }
                if (s % 2 == 1) {
                    res *= i;
                }
            }
        }
        if (n > 1) {
            res *= n;
        }
        System.out.println(res);
        in.close();
    }
}