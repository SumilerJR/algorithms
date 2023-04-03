import java.io.*;
import java.util.*;

public class Main {
    // static BufferedReader in = new BufferedReader(new
    // InputStreamReader(System.in));
    // static BufferedWriter out = new BufferedWriter(new
    // OutputStreamWriter(System.out));
    final static int N = 100010;
    static int n;

    static class Edge {
        int id, w;

        public Edge(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }

    static List<Edge>[] h = new List[N];
    static int[] dist = new int[N];

    public static void main(String[] args) throws Exception {
        // n = Integer.parseInt(in.readLine().trim());
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < N; i++) {
            h[i] = new LinkedList<Edge>();
        }
        for (int i = 1; i < n; i++) {
            // String[] data = in.readLine().trim().split(" ");
            // int a = Integer.parseInt(data[0].trim());
            // int b = Integer.parseInt(data[1].trim());
            // int c = Integer.parseInt(data[2].trim());
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            h[a].add(new Edge(b, c));
            h[b].add(new Edge(a, c));
        }
        dfs(1, -1, 0);
        int u = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[u]) {
                u = i;
            }
        }
        dfs(u, -1, 0);
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[u]) {
                u = i;
            }
        }
        int s = dist[u];
        System.out.println(s * 10 + s * (s + 1L) / 2);
        // out.write(s * 10 + s * (s + 1L) / 2 + "");
        // in.close();
        // out.close();
    }

    public static void dfs(int u, int father, int distance) {
        dist[u] = distance;
        for (int i = 0; i < h[u].size(); i++) {
            Edge node = h[u].get(i);
            if (node.id != father) {
                dfs(node.id, u, distance + node.w);
            }
        }
    }
}