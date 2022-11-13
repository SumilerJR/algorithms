public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int n = input.nextInt();
        while (n != 0) {
            count++;
            n /= 2;
        }
        System.out.println(count);
    }
}