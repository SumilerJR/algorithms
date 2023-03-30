import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    final static int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {
        while (true) {
            String[] data = in.readLine().split(" ");
            int w = Integer.parseInt(data[0]);
            int h = Integer.parseInt(data[1]);
            if (w == 0 && h == 0) {
                break;
            }
            char[][] map = new char[h][w];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                // map[i] = in.readLine().toCharArray();
                data = in.readLine().split("");
                for (int j = 0; j < w; j++) {
                    map[i][j] = data[j].charAt(0);
                    if (map[i][j] == '@') {
                        queue.offer(new int[] { i, j });
                        map[i][j] = '#';
                    }
                }
            }
            int count = 1;
            while (!queue.isEmpty()) {
                int[] coord = queue.poll();
                for (int[] dir : dirs) {
                    int x = coord[0] + dir[0];
                    int y = coord[1] + dir[1];
                    if (x < 0 || x >= h || y < 0 || y >= w) {
                        continue;
                    }
                    if (map[x][y] == '#') {
                        continue;
                    }
                    count++;
                    queue.offer(new int[] { x, y });
                    map[x][y] = '#';
                }
            }
            out.write(count + "\n");
        }
        in.close();
        out.close();
    }
}