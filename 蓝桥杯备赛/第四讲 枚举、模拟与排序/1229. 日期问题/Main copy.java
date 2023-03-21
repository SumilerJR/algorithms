import java.io.*;
import java.util.*;
// 23/03/21 年月日
// 03/21/23 月日年
// 21/03/23 日月年
public class Main {
    static int[] d = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split("/");
        int a = Integer.parseInt(readLine[0]);
        int b = Integer.parseInt(readLine[1]);
        int c = Integer.parseInt(readLine[2]);
        String[] res = new String[3];
        if (check(a, b, c)) {
            System.out.println(a + "-" + b + "-" + c);
        }
        if (check(b, c, a)) {
            System.out.println(b + "-" + c + "-" + a);
        }
        if (check(c, b , a)) {
            System.out.println(c + "-" + b + "-" + a);
        }



    }
    public static boolean check(int year, int month, int day) {
        if (year >= 60) {
            year += 1900;
        } else {
            year += 2000;
        }
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