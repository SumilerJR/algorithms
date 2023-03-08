import java.util.*;
public class Main {
    static int n, k;
    static List<int[]> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            list.add(new int[]{h, w});
        }
        int left = 0, right = 100000;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(right);
    }

    static public boolean check(int mid) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] chocolate = list.get(i);
            int x = chocolate[0] / mid, y = chocolate[1] / mid;
            res += x * y;
            if (res >= k) {
                return true;
            }
        }
        return false;
    }
}