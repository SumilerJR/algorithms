import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int l, r, c;// 层数，行数，列数
    static char[][][] map;
    final static int[][] dirs = new int[][] { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 },
            { 0, 0, 1 } };

    public static void main(String[] args) throws Exception {
        while (true) {
            String[] data = in.readLine().split(" ");
            l = Integer.parseInt(data[0]);
            r = Integer.parseInt(data[1]);
            c = Integer.parseInt(data[2]);
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            map = new char[l][r][c];
            int h = 0, x = 0, y = 0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    data = in.readLine().split("");
                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = data[k].charAt(0);
                        if (map[i][j][k] == 'S') {
                            h = i;
                            x = j;
                            y = k;
                        }
                    }
                }
                in.readLine();

            }
            int res = bfs(h, x, y);
            if (res == -1) {
                out.write("Trapped!" + "\n");
            } else {
                out.write("Escaped in " + res + " minute(s)." + "\n");
            }
        }

        in.close();
        out.close();
    }

    public static int bfs(int h, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { h, x, y });
        map[h][x][y] = '#';// 封入口
        // int[][][] dist = new int[l][r][c];
        int step = 1;// 最短步数
        while (!queue.isEmpty()) {
            int size = queue.size();// 记录队列的长度，即每一步的方向个数
            while (size-- > 0) {// 要用step一个变量记录最短路径的话，要多套一层以队列大小为次数的循环
                int[] coord = queue.poll();
                for (int[] dir : dirs) {
                    int dh = coord[0] + dir[0];
                    int dx = coord[1] + dir[1];
                    int dy = coord[2] + dir[2];
                    if (dh < 0 || dh >= l || dx < 0 || dx >= r || dy < 0 || dy >= c) {
                        continue;// 越界结束
                    }
                    // System.out.printf("%d, %d, %d \n", dh, dx, dy);
                    // dist[dh][dx][dy] = dist[coord[0]][coord[1]][coord[2]] + 1;// 计算步数
                    if (map[dh][dx][dy] == '#') {
                        continue;
                    }
                    if (map[dh][dx][dy] == 'E') {
                        return step;
                        // return dist[dh][dx][dy];
                    }
                    queue.offer(new int[] { dh, dx, dy });
                    map[dh][dx][dy] = '#';// 封口
                }
            }
            step++;// 执行一次循环说明走了一步，因此加一步
        }
        return -1;// 队为空之前都没有到达终点，说明没有路走得通，返回-1
    }

}