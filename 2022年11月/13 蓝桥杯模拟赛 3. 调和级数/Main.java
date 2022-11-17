public class Main {
    public static void main(String[] args) {
        double sum = 0;
        int i = 0;
        while (sum <= 12) {
            sum += 1.0 / (i + 1);
            i++;
        }
        System.out.println(i);
    }
}