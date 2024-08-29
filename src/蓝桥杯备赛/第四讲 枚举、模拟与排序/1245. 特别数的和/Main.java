import java.util.*;
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            String s = Integer.toString(i);
            if (s.indexOf('2') != -1 || s.indexOf('0') != -1 || s.indexOf('1') != -1 || s.indexOf('9') != -1) {
                res += i;
            }
        }
        System.out.print(res);
    }
}