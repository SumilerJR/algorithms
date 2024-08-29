import java.util.*;

// 2066. 解码-AcWing题库
// https://www.acwing.com/problem/content/2068/
public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        char[] chars = in.nextLine().toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int j = chars[i] - '1';
                char c = chars[i - 1];
                while (j-- > 0) {
                    sb.append(c);
                }
            } else {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
        in.close();
    }

}