import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // int n, q;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            int left = 0, right = n - 1;
            // 二分k的左端点
            while (left < right) {
                int mid = (left + right) / 2;
                if (k <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (arr[left] == k) {
                System.out.print(left + " ");
                // left = 0;
                right = n - 1;
                // 二分k的右端点
                while (left < right) {
                   int mid = (left + right + 1) / 2;
                   if (k >= arr[mid]) {
                       left = mid;
                   } else {
                       right = mid - 1;
                   }
                }
                System.out.println(right);
            } else {
                System.out.println("-1 -1");
            }
        }

    }
}