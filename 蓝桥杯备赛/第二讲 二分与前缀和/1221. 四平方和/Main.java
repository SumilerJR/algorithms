import java.util.*;
// 暴力（优化）
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a = 0; a * a * 4<= n; a++) {
            for (int b = a; a * a + b * b * 3 <= n; b++) {
                for (int c = b; a * a + b * b + c * c * 2 <= n; c++) {
                    int t = n - (a * a + b * b + c * c);
                    int d = (int)Math.sqrt(t);
                    if (d * d == t) {
                        System.out.println(a + " " + b + " " + c + " " + d);
                        return;
                    }
                }
            }
        }
    }
}