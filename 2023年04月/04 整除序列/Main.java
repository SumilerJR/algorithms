import java.util.*;

// 2065. 整除序列-AcWing题库
// https://www.acwing.com/problem/content/2067/
public class Main {
    static Scanner in = new Scanner(System.in);
    static long n;

    public static void main(String[] args) {
        n = in.nextLong();
        while (n > 0) {
            System.out.print(n + " ");
            n /= 2;
        }
        in.close();
    }

}