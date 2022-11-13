public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        String[] time = input.next().split(":");
        int h = Integer.valueOf(time[0]) * 60 * 60;
        int m = Integer.valueOf(time[1]) * 60;
        int s = Integer.valueOf(time[2]);
        int t = h + m + s;
        int U = input.nextInt();
        int I = input.nextInt();
        int resW = 0;
        for (int i = 1; i < n; i++) {
            time = input.next().split(":");
            int h1 = Integer.valueOf(time[0]) * 60 * 60;
            int m1 = Integer.valueOf(time[1]) * 60;
            int s1 = Integer.valueOf(time[2]);
            int t1 = h1 + m1 + s1;
            resW += (t1 - t) * U * I;
            U = input.nextInt();
            I = input.nextInt();
            t = t1;
        }
        System.out.println(resW);
    }
}