import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        String[] data = readLine.split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int t = Integer.parseInt(data[2]);
        int[] score = new int[100010];//当前的优先级
        int[] last = new int[100010];//上一个有订单的时刻
        boolean[] flag = new boolean[100010];//是否在优先缓存中
        // int top = 5;
        int[][] mm = new int[m][2];
        for (int i = 0; i < m; i++) {
            data = br.readLine().split(" ");
            int ts = Integer.parseInt(data[0]);
            int id = Integer.parseInt(data[1]);
            mm[i][0] = ts;
            mm[i][1] = id;
        }
        Arrays.sort(mm, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];//排序的时候，要注意如果时间ts相同，则对id进行排序
            }
        });



        for (int i = 0; i < m; i++) {
            int ts = mm[i][0];//时刻
            int id = mm[i][1];//id
            int j = i;
            //比较时刻与id是否都相同
            while (j < m && mm[i][0] == mm[j][0] && mm[i][1] == mm[j][1]) {
                j++;
            }
            int count = j - i;
            i = j - 1;

            score[id] -= ts - last[id] - 1;//减去之前的时刻
            if (score[id] < 0) score[id] = 0;//若小于零也要归零
            if (score[id] <= 3) {
                flag[id] = false;//判断是否移除
            }

            score[id] += 2 * count;//加上当前的权重

            if (score[id] > 5) {
                flag[id] = true;//盘那段是否加入到优先缓存
            }
            last[id] = ts;
        }
        //遍历所有店家
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            //若是该店家最近的订单活跃时刻不满足t，那么就需要进行减去相应的时刻分数
            if (last[i] < t) {
                score[i] -= t - last[i];
                if (score[i] <= 3)
                    flag[i] = false;
            }
            if (flag[i]) ans++;
        }
        System.out.println(ans);
    }
}