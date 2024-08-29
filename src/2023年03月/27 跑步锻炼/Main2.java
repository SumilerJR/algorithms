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
        for (int year = 2000; year <= 2020; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                // 闰年
                days[2] = 29;
            } else {
                days[2] = 28;
            }
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= days[month]; day++) {
                    if (week == 1 || day == 1) {
                        ans += 2;
                    } else {
                        ans += 1;
                    }
                    week = (week + 1) % 7;
                    if (year == 2020 && month == 10 && day == 1) {
                        System.out.print(ans);
                    }
                }
            }
        }

        scan.close();
    }
}