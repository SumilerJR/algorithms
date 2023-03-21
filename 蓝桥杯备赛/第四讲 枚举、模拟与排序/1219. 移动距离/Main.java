import java.io.*;
import java.util.*;
// 0 1 2 3 4 5
// 11 10 9 8 7 6
// 12 13 14 15 16 17
// 为了减少特判的麻烦，把下标改为从0开始
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");
        int w = Integer.parseInt(readLine[0]);
        int m = Integer.parseInt(readLine[1]) - 1;//下标-1
        int n = Integer.parseInt(readLine[2]) - 1;
        int mX = m / w, nX = n / w;
        int mY = mX % 2 == 0 ? m % w : w - (m % w) - 1;//偶数为正向
        int nY = nX % 2 == 0 ? n % w : w - (n % w) - 1;
        int ans = Math.abs(mX - nX) + Math.abs(mY - nY);
        System.out.print(ans);
    }
}