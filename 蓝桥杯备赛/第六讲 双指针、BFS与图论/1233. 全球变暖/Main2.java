import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static char[][] map;
    static int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(in.readLine());
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            String data = in.readLine();
            map[i] = data.toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '#' && bfs(i, j)) {
                    ans++;
                }
            }
        }
        out.write(ans + "\n");
        in.close();
        out.close();
    }

    public static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        map[x][y] = '@';
        boolean res = true;
        int total = 0;// 代表土地块数
        int bound = 0;// 代表被海水淹没的数量
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            boolean is_bound = false;// 该块土地是否会被淹没
            for (int[] dir : dirs) {
                int dx = coord[0] + dir[0];
                int dy = coord[1] + dir[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= n) {
                    continue;
                } else if (map[dx][dy] == '@') {
                    continue;
                } else if (map[dx][dy] == '.') {
                    is_bound = true;
                } else if (map[dx][dy] == '#') {
                    queue.offer(new int[] { dx, dy });
                    map[dx][dy] = '@';
                }
            }
            if (is_bound) {
                bound++;// 会淹没，则统计+1
            }
            total++;
        }
        return bound == total;
    }

}