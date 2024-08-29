import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 傻逼题目
public class Main {
    static int N = 310;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[] dx = new int[] { 0, -1, 0, 1 };
    static int[] dy = new int[] { -1, 0, 1, 0 };
    // 有3种形态，例如长度是5 * 5，则中心是(x, y)，对应的区域是左上角(x - 2, y - 2)，右上角(x + 2, y + 2)，左下角(x -
    // 2, y + 2)，右下角(x + 2, y + 2)
    static int[] d = new int[] { 2, 1, 0 };
    static int n, k;

    static int bfs() {
        Queue<Edge> q = new LinkedList<Edge>();
        q.add(new Edge(3, 3, 0));
        st[3][3] = true;
        while (!q.isEmpty()) {
            Edge t = q.poll();
            // 将源点加入到队列
            q.add(new Edge(t.x, t.y, t.time + 1));

            // 枚举4个方向
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i], b = t.y + dy[i];
                int fat = t.time / k >= 2 ? 0 : d[t.time / k];// 判断有多胖
                if (st[a][b])
                    continue;
                if (a - fat < 1 || a + fat > n || b - fat < 1 || b + fat > n)
                    continue;
                // 判断该区域是否有障碍物
                boolean flag = false;// 初始没有障碍物
                for (int u = a - fat; u <= a + fat; u++)
                    for (int v = b - fat; v <= b + fat; v++)
                        if (g[u][v] == '*')
                            flag = true;
                if (flag)
                    continue;
                if (a == n - 2 && b == n - 2)
                    return t.time + 1;// 到达终点

                st[a][b] = true;
                // 加入到队列
                q.add(new Edge(a, b, t.time + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            char[] temp = scan.next().toCharArray();
            for (int j = 1; j <= n; j++) {
                g[i][j] = temp[j - 1];
            }
        }

        System.out.println(bfs());
    }
}

class Edge {
    int x, y, time;

    Edge(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
