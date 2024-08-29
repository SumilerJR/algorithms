import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ants = new int[n];
        int leftToRight = 0, rightToLeft = 0;
        for (int i = 0; i < n; i++) {
            ants[i] = in.nextInt();
        }
        int firstAnt = Math.abs(ants[0]);
        for (int i = 1; i < n; i++) {
            if (Math.abs(ants[i]) > firstAnt && ants[i] < 0) {
                rightToLeft++;
            } else if (Math.abs(ants[i]) < firstAnt && ants[i] > 0) {
                leftToRight++;
            }
        }
        if ((ants[0] > 0 && rightToLeft == 0) || (ants[0] < 0 && leftToRight == 0)) {
            System.out.print(1);
        } else {
            System.out.print(leftToRight + rightToLeft + 1);
        }
    }
}