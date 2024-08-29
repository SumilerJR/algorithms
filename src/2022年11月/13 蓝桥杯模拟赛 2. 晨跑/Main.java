public class Main {
    public static void main(String[] args) {
        int[] mon = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int week = 6;
        int res = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j <= mon[i]; j++, week++) {
                week %= 7;
                if (week == 6 || week == 0 || j == 1 || j == 11 || j == 21 || j == 31) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}