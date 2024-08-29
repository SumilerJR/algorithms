import java.util.*;
import java.io.*;

// 1208. 翻硬币 - AcWing题库
// https://www.acwing.com/problem/content/description/1210/
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static char[] start;
    static char[] end;

    public static void main(String[] args) throws Exception {
        start = in.readLine().toCharArray();
        end = in.readLine().toCharArray();
        int step = 0;
        for (int i = 0; i < start.length - 1; i++) {
            if (start[i] != end[i]) {
                turn(i);
                turn(i + 1);
                step++;
            }
        }
        System.out.println(step);
        in.close();
    }

    static void turn(int i) {
        start[i] = start[i] == '*' ? 'o' : '*';
    }
}
