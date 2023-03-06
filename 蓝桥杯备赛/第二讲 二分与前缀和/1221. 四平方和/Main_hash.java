import java.util.*;
//哈希打表
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, int[]> map = new HashMap<>();
        for (int c = 0; c * c <= n; c++) {
            for (int d = c; d * d + c * c <= n; d++) {
                int sum = c * c + d * d;
                if (!map.containsKey(sum)) {
                    map.put(sum, new int[]{0, 0, c, d});
                }
            }
        }

        for (int a = 0; a * a <= n; a++) {
            for (int b = a; a * a + b * b <= n; b++) {
                int sum = n - a * a - b * b;
                if (map.containsKey(sum)) {
                    int[] res = map.get(sum);
                    res[0] = a;
                    res[1] = b;
                    for (int i : res) {
                        System.out.print(i + " ");
                    }
                    return;
                }
            }
        }
    }
}