import java.util.*;

// AcWing 4404. X 进制减法 - AcWing
// https://www.acwing.com/activity/content/problem/content/6830/
// 一把梭哈
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.max(i, n - i - 1) * 2;
        }
        for (int k : res) {
            System.out.println(k);
        }
        in.close();
    }
}