import java.util.*;

public class Main {
    final static int N = 100010;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), d = in.nextInt(), k = in.nextInt();
        // ArrayList<Integer> list = new ArrayList<>();
        int[][] logs = new int[n][2];
        boolean[] flag = new boolean[N];
        int[] count = new int[N];
        for (int i = 0; i < n; i++) {
            int ts = in.nextInt(), id = in.nextInt();
            logs[i][0] = ts;
            logs[i][1] = id;
        }
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        for (int left = 0, right = 0; right < n; right++) {
            int id = logs[right][1];
            count[id]++;
            while (logs[right][0] - logs[left][0] >= d) {
                count[logs[left][1]]--;
                left++;
            }
            if (count[id] >= k)
                flag[id] = true;
        }

        for (int i = 0; i < N; i++) {
            if (flag[i]) {
                System.out.println(i);
            }
        }
        in.close();
        return;
    }
}
