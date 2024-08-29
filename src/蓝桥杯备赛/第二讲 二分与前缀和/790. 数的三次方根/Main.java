import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double left = -10000, right = 10000, mid = 0;
        while (right - left > 1e-8) {//多判断两个小数位
            mid = (left + right) / 2;
            if (mid * mid * mid >= n) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.print(String.format("%.6f", mid));//格式化输出
    }
}