import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N = 100010;
    static int n;

    static int[] list = new int[N];
    static int[] map = new int[N];
    static int idx = 1;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = in.readLine().split(" ");
            char mark = data[0].charAt(0);
            switch (mark) {
                case 'H':
                    addHead(Integer.parseInt(data[1]));
                    break;
                case 'D':
                    remove(Integer.parseInt(data[1]));
                    break;
                case 'I':
                    insert(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                    break;
            }
        }
        // out.write(list[0] + " " + map[0] + "\n");
        for (int i = list[0]; i != 0; i = list[i]) {
            out.write(map[i] + " ");
        }
        in.close();
        out.close();
    }

    public static void addHead(int x) {
        insert(0, x);
    }

    public static void remove(int k) {
        list[k] = list[list[k]];
    }

    public static void insert(int k, int x) {
        list[idx] = list[k];
        list[k] = idx;
        map[idx] = x;
        idx++;
    }

}