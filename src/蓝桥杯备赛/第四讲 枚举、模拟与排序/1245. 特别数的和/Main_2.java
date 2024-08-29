import java.util.*;
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            int t = i;
            while (t > 0) {
                int x = t % 10;
                if (x == 2 || x == 0 || x == 1 || x == 9) {
                    res += i;
                    break;
                }
                t /= 10;
            }
        }
        System.out.print(res);
    }
}