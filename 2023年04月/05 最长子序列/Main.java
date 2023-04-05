import java.io.*;
import java.util.*;

// 2558. 最长子序列-AcWing题库 https://www.acwing.com/problem/content/2560/
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] t = in.next().toCharArray();
        int ans = 0;
        for (int i = 0, j = 0; i < t.length; i++) {
            j = s.indexOf(t[i], j + 1);
            if (j != -1) {
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
        in.close();
    }
}