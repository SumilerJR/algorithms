public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int res = n > m ? n - m : n + 7 - m;
        System.out.println(res);
    }
}