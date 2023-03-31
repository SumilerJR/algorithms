import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int t = Integer.valueOf(in.readLine());
        while (t-- > 0) {
            String[] data = in.readLine().split(" ");
            int r = Integer.valueOf(data[0]), c = Integer.valueOf(data[1]);
            char[][] map = new char[r][c];
            int x = 0, y = 0;
            for (int i = 0; i < r; i++) {
                data = in.readLine().split("");
                for (int j = 0; j < c; j++) {
                    map[i][j] = data[j].charAt(0);
                    if (map[i][j] == 'S') {
                        x = i;
                        y = j;
                    }
                }
            }
            int res = bfs(map, x, y);
            if (res == -1) {
                out.write("oop!\n");
            } else {
                out.write(res + "\n");
            }
        }

        in.close();
        out.close();
    }

    final static int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static int bfs(char[][] map, int x, int y) {
        int row = map.length, col = map[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // int[][] dist = new int[row][col];// 计算距离
        queue.offer(new int[] { x, y });
        map[x][y] = '#';// 手动封入口
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] address = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int r = address[0] + dir[i][0];
                    int c = address[1] + dir[i][1];
                    if (r < 0 || r >= row || c < 0 || c >= col || map[r][c] == '#') {
                        continue;
                    }
                    // dist[r][c] = dist[address[0]][address[1]] + 1;// 要把该行放在出口前，否则出口一直为0……
                    if (map[r][c] == 'E') {
                        // return String.valueOf(dist[r][c]);
                        return step;
                    } else {
                        queue.offer(new int[] { r, c });
                        map[r][c] = '#';// 标记为来过
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
