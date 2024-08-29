// import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        // String line = br.readLine();
        // int n = Integer.parseInt(line);
        int n = sc.nextInt();
        int ans = n;
        while (n >= 3) {
            int temp =  n / 3;//下取整，至于上取整：a / b 上取整 = (a + b - 1) / b 下取整
            n = n % 3 + temp;
            ans += temp;
        }
        System.out.print(ans);
    }
}