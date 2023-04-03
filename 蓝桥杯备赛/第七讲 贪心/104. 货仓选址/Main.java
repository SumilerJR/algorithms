import java.util.*;

// 一个店铺时，仓库在店铺上距离最小为0
// 两个店铺时，仓库只要在两个店铺间时，不管离谁近，总距离都是一样的为店铺间的距离
// 三个店铺时，仓库在中间店铺上时总距离最小
// 四个店铺时，仓库在中间两个店铺之间时总距离最小
// ……
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
