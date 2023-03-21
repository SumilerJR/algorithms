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
        for (int date = 19600101; date < 20600101; ++date) {
            int year = date / 10000;
            int month = date % 10000 / 100;
            int day = date % 100;
            if (check(year, month, day)) {
                if ((year % 100 == a && month == b && day == c) ||
                (year % 100 == c && month == a && day == b) ||
                (year % 100 == c && month == b && day == a)
                ) {
                    System.out.printf("%d-%02d-%02d\n",year, month, day);
                }
            }
        }

    }
    // 判断日期是否正确
    public static boolean check(int year, int month, int day) {
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