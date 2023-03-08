// import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    public static void main(String[] args)throws Exception {
        // Scanner in = new Scanner(System.in);
        map = new int[5010][5010];
        // int n = in.nextInt(), r = in.nextInt();
        // r = Math.min(r, 5001);      //边长最大是5001。被坑了好久。
        int max_x = 0, max_y = 0;

        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        String [] line = BR.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        r = Math.min(r, 5001);
        // String [] line = BR.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            // int x = in.nextInt(), y = in.nextInt(), w = in.nextInt();
            line = BR.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            map[x + 1][y + 1] += w;
            // max_x = Math.max(max_x, x + 1);
            // max_y = Math.max(max_y, y + 1);
        }
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                map[i][j] += map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }
        int max = 0;
        for (int i = r; i < map.length; i++) {
            for (int j = r; j < map[0].length; j++) {
                // int k = i - r + 1, l = j - r + 1;
                int cur_w = map[i][j] - map[i - r][j] - map[i][j - r] + map[i - r][j - r];
                max = Math.max(max, cur_w);

            }
        }
        System.out.print(max);
    }
}