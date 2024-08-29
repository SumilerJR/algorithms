import java.util.*;

// 2871. 成绩统计 - AcWing题库
// https://www.acwing.com/problem/content/2874/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double youxiu = 0, jige = 0;
        for (int i = 0; i < n; i++) {
            int chengji = in.nextInt();
            if (chengji >= 60)
                jige++;
            if (chengji >= 85)
                youxiu++;
        }
        System.out.println((int) (jige / n * 100 + 0.5) + "%");
        System.out.println((int) (youxiu / n * 100 + 0.5) + "%");
        in.close();
    }
}
