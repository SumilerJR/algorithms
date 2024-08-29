import java.util.*;
import java.io.*;
public class Main {
    static int[] d = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine().split(" ")[0]);
        int end = Integer.parseInt(br.readLine().split(" ")[0]);
        int ans = 0;
        for (int i = 1000; i < 10000; i++) {
            int date = i, x = i;
            for (int j = 0; j < 4; j++) {
                date = date * 10 + x % 10;
                x /= 10;
            }
            if (date >= start && date <= end && check(date)) {
                ans++;
            }
        }
        System.out.print(ans);
    }
    // 判断日期是否正确
    public static boolean check(int date) {
        int year = date / 10000;
        int month = date % 10000 / 100;
        int day = date % 100;
        // if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
        //     d[2] = 29;
        // } else  {
        //     d[2] = 28;
        // }
        // if (!(month >= 1 && month <= 12) || !(day >= 1 && day <= d[month])) {
        //     return false;
        // }
        if (!(month >= 1 && month <= 12)) return false;
        if (month != 2 && !(day >= 1 && day <= d[month])) return false;
        if (month == 2) {
            int m = 28;
            if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
                //是闰年
                m = 29;
            }
            if (!(day >= 1 && day <= m)) return false;
        }
        return true;
    }
}