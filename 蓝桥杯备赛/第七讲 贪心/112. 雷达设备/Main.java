import java.util.*;

public class Main {
    static int N = 1010;

    static class Segment {
        double l, r;

        Segment() {
        }

        Segment(double l, double r) {
            this.l = l;
            this.r = r;
        }
    }

    static class compa implements Comparator<Segment> {

        @Override
        public int compare(Segment a, Segment b) {
            if (a.r > b.r) {
                return 1;
            } else if (a.r == b.r) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    static int n, d;
    static Segment[] map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        d = in.nextInt();
        boolean failed = false;
        map = new Segment[n];
        // Arrays.fill(map, new Segment(0, 0));
        for (int i = 0; i < n; ++i) {
            int x = in.nextInt() + 1000;
            int y = in.nextInt();
            if (y > d) {
                failed = true;
            } else {
                double len = Math.sqrt(d * d - y * y);
                map[i] = new Segment(x - len, x + len);
                // map[i].l = x - len;
                // map[i].r = x + len;
            }
        }
        if (failed) {
            System.out.println("-1");
        } else {
            Arrays.sort(map, new compa());
            int cnt = 0;
            double last = -1e20;
            for (int i = 0; i < n; i++) {
                if (last < map[i].l) {
                    cnt++;
                    last = map[i].r;
                }
            }
            System.out.println(cnt);
        }

    }

}
