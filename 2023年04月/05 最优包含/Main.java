import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double count = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            max = Math.max(max, a);
            min = Math.min(min, a);
            count += a;
        }
        System.out.printf("%d\n%d\n%.2f", max, min, count / n);
        in.close();
    }
}