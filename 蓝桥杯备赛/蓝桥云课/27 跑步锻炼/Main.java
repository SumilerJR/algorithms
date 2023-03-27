import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    static int[] days = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 在此输入您的代码...
        int ans = 0;
        int week = 6;
        for (int date = 20000101; date < 20201001; date++) {
            if (check(date)) {
                if (week % 7 == 1 || date % 100 == 1) {
                    ans += 2;
                } else {
                    ans += 1;
                }
                week++;
                week %= 7;
            }
        }
        System.out.print(ans);
        scan.close();
    }

    // 20000101
    public static boolean check(int date) {
        int day = date % 100;
        int month = date / 100 % 100;
        int year = date / 10000;
        if (!(month >= 1 && month <= 12))
            return false;
        if (month != 2 && !(day >= 1 && day <= days[month]))
            return false;
        if (month == 2) {
            int m = 28;
            if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
                // 是闰年
                m = 29;
            }
            if (!(day >= 1 && day <= m))
                return false;
        }
        return true;

    }
}