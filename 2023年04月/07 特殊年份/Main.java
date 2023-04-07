import java.util.*;

// 3496. 特殊年份 - AcWing题库
// https://www.acwing.com/problem/content/3499/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            String date = in.next();
            int d1 = Integer.parseInt(date.substring(0, 1));
            int d2 = Integer.parseInt(date.substring(1, 2));
            int d3 = Integer.parseInt(date.substring(2, 3));
            int d4 = Integer.parseInt(date.substring(3, 4));
            if (d1 == d3 && d4 == d2 + 1) {
                ans++;
            }
        }
        System.out.println(ans);
        in.close();
    }
}