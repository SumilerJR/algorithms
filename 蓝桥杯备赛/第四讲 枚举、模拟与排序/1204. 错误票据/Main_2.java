import java.io.*;
import java.util.*;
public class Main {
    static int n;
    // static int[] map;
    static int[] arr;
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().split(" ")[0]);
        // map = new int[100010];
        // arr = new int[n * 100 + 5];
        List<Integer> list = new ArrayList<Integer>();
        // int start = 100, end = 0;
        for (int i = 0; i < n; ++i) {
            String[] len = br.readLine().split(" ");
            for (String s : len) {
                int x = Integer.parseInt(s);
                // start = Math.min(start, x);
                // end = Math.max(end, x);
                // map[x]++;
                list.add(x);
            }
        }
        int m = 0, n = 0;
        // arr.sort();
        // list.sort(Comparator.naturalOrder());
        Collections.sort(list);
        for (int i = 1; i < list.size(); ++i) {
            // System.out.println(list.get(i) + " " + list.get(i - 1));
            int a1 = list.get(i);
            int a2 = list.get(i - 1);
            if (a1 == a2) {
                n = list.get(i);
            } else if (a1 > a2 + 1) {
                m = a1 - 1;
            }
            //不知道为什么if不成立
            // if (list.get(i) == list.get(i - 1)) {
            //     n = list.get(i);
            //     System.out.println(list.get(i) + " " + list.get(i - 1));
            // } else if (list.get(i) > list.get(i - 1) + 1) {
            //     m = list.get(i) - 1;
            // }
        }
        System.out.print(m + " " + n);
    }
}