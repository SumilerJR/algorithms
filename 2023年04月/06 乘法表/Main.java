import java.util.*;

// 2876. 日期识别-AcWing题库 https://www.acwing.com/problem/content/2879/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int i = 1; i < p; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%s ", i, j, Integer.toString(i * j, p));
            }
            System.out.println();
        }

        in.close();
    }

}
