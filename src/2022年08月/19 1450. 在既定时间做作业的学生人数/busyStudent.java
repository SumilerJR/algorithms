// 差分数组
//执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：41 MB, 在所有 Java 提交中击败了5.17%的用户
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] arr = new int[1008];
        for (int i = 0; i < startTime.length; i++) {
            arr[startTime[i]]++;
            arr[endTime[i] + 1]--;
        }
        for (int i = 1; i <= queryTime; i++) {
            arr[i] += arr[i - 1];
        }
        return arr[queryTime];
    }
}

//枚举
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.4 MB, 在所有 Java 提交中击败了59.94%的用户
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime)
                count++;
        }
        return count;
    }
}