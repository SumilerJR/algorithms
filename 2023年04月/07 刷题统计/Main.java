import java.util.*;

// 4402. 刷题统计 - AcWing题库
// https://www.acwing.com/problem/content/description/4405/
// 不要总想着模拟！！！从整体出发！能直接计算n周答案的何乐而不为！之后只需要加上最后不到一周的天数就可以计算出！
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long n = in.nextLong();
        long week = n / (a * 5 + b * 2);// 要花多少周(缺)
        long day = week * 7;// 计算答案天数
        long count = week * (a * 5 + b * 2);
        for (int i = 0; i < 5 && count < n; i++) {
            day++;
            count += a;
        }
        for (int i = 0; i < 2 && count < n; i++) {
            day++;
            count += b;
        }
        System.out.println(day);
        in.close();
    }
}