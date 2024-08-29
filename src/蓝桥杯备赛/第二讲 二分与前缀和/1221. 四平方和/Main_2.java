import java.util.*;
public class Main {
    static class Sum {
        int c;
        int d;
        int s;
        public Sum(int c, int d, int s) {
            this.c = c;
            this.d = d;
            this.s = s;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Sum[] arr = new Sum[5000010];
        List<Sum> list = new ArrayList<Sum>();
        for (int c = 0; c * c <= n; c++) {
            for (int d = 0; d * d + c * c <= n; d++) {
                int t = c * c + d * d;
                list.add(new Sum(c, d, t));
            }
        }
        list.sort((a, b) -> {
            if (a.s != b.s) return a.s - b.s;
            else if (a.c != b.c) return a.c - b.c;
            else return a.d - b.d;
        });
        for (int a = 0; a * a <= n; a++) {
            for (int b = a; a * a + b * b <= n; b++) {
                int t = n - a * a - b * b;
                int left = 0, right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (t <= list.get(mid).s) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (list.get(left).s == t) {
                    System.out.println(a + " " + b + " " + list.get(left).c + " " +list.get(left).d);
                    return;
                }
            }
        }
    }
}