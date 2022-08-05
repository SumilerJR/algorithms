//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：38.7 MB, 在所有 Java 提交中击败了22.91%的用户
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);//每次消去一个1
            count++;
        }
        return count;
    }
}
