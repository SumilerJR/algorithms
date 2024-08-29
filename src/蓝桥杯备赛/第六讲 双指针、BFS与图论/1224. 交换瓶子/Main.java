import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    final static int N = 10010;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        boolean[] state = new boolean[N];
        String[] data = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(data[i - 1]);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!state[i]) {
                count++;
                for (int j = i; !state[j]; j = arr[j]) {
                    state[j] = true;
                }
            }
        }
        out.write(n - count + "");
        out.close();
        out.close();
    }
}
