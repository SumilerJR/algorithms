import java.util.*;

public class Main {
    static int N = 40010;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] shop = new int[n];
        for (int i = 0; i < n; i++) {
            shop[i] = in.nextInt();
        }
        Arrays.sort(shop);
        int k = shop[n / 2];// n为奇数时，是中位数，是偶数时，是最中间两数间较大的数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(shop[i] - k);
        }
        System.out.print(ans);
        in.close();
    }
}
