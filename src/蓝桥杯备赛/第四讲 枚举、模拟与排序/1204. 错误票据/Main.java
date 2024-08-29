import java.io.*;
public class Main {
    static int n;
    static int[] map;
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().split(" ")[0]);
        map = new int[100010];
        int start = 100, end = 0;
        for (int i = 0; i < n; ++i) {
            String[] len = br.readLine().split(" ");
            for (String s : len) {
                int x = Integer.parseInt(s);
                start = Math.min(start, x);
                end = Math.max(end, x);
                map[x]++;
            }
        }
        int m = 0, n = 0;
        for (int i = start; i <= end; ++i) {
            if (map[i] == 0) {
                m = i;
            } else if (map[i] == 2) {
                n = i;
            }
        }
        System.out.print(m + " " + n);
    }
}