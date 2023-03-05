import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N + 1];
        // int[] map = new int[N + 1];//可以省略这个dp数组
        int minE = 0;//改为一个数代替
        for (int i = 1; i <= N; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = N - 1; i >= 0; i--) {
            minE = (minE + arr[i + 1] + 1) / 2;
        }
        System.out.print(minE);
    }
}