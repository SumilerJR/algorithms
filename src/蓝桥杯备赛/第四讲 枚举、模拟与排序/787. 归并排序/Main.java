import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");
        int n = Integer.parseInt(readLine[0]);
        int[] arr = new int[n];
        readLine = br.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(readLine[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }


    }
}