import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i  = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt() + arr[i - 1];

        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println(arr[r] - arr[l - 1]);
        }
    }
}