import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            int min = arr[i], max = arr[i];
            for (int j = i; j < n; ++j) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if (max - min == j - i) {
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }
}