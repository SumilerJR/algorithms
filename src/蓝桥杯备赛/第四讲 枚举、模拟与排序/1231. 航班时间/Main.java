import java.io.*;
import java.util.*;
// public class Date {
//     int hour;
//     int minute;
//     int second;
//     public Date(hour, minute, second)  {
//         this.hour = hour;
//         this.minute = minute;
//         this.second = second;
//     }
// }

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; ++i) {
            int time = (getTime() + getTime()) / 2;
            int hour = time / 3600, minute = time % 3600 / 60, second = time % 60;
            System.out.printf("%02d:%02d:%02d\n",hour, minute, second);
        }
    }
    public static int getTime() throws Exception {
        String readLine = br.readLine();
        if (readLine.charAt(readLine.length() - 1) != ')') {
            readLine += " (+0)";
        }
        String[] data = readLine.split(" ");
        String[] date1 = data[0].split(":");
        String[] date2 = data[1].split(":");

        int h1 = Integer.parseInt(date1[0]);
        int m1 = Integer.parseInt(date1[1]);
        int s1 = Integer.parseInt(date1[2]);
        int h2 = Integer.parseInt(date2[0]);
        int m2 = Integer.parseInt(date2[1]);
        int s2 = Integer.parseInt(date2[2]);
        int d = Character.getNumericValue(data[2].charAt(data[2].length() - 2));
        return getSecond(h2, m2, s2) - getSecond(h1, m1, s1) + d * 24 * 3600;
    }

    public static int getSecond(int hour, int minute, int second) {
        return hour * 3600 + minute * 60 + second;
    }

}