import java.util.*;

// 2876. 日期识别-AcWing题库 https://www.acwing.com/problem/content/2879/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] map = new String[] { "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
                "Dec" };
        String date = in.next();
        String month = date.substring(0, 3);
        int day = Integer.parseInt(date.substring(3, date.length()));
        for (int i = 1; i <= 12; i++) {
            if (map[i].equals(month)) {
                System.out.println(i + " " + day);
            }
        }
        in.close();
    }
}
