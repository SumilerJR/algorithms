import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(in.readLine());
        String[] data = in.readLine().split(" ");
        int[] weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(data[i - 1]);
        }
        long max = Long.MIN_VALUE;
        int depth = 1;
        for (int i = 1, d = 1; i <= n; i *= 2, d++) {
            long count = 0;
            for (int j = i; j < (1 << d) && j <= n; j++) {
                count += weight[j];
            }
            if (count > max) {
                depth = d;
                max = count;
            }
        }
        out.write(depth + "");
        in.close();
        out.close();
    }
}