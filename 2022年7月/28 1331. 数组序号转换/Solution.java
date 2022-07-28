//执行用时：38 ms, 在所有 Java 提交中击败了21.08%的用户
//内存消耗：53 MB, 在所有 Java 提交中击败了74.30%的用户
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int length = arr.length;
        if (length == 0)
            return new int[0];
        int[] result = new int[length];
        int[][] map = new int[length][2];
        for (int i = 0; i < length; i++) {
            map[i][0] = arr[i];
            map[i][1] = i;
        }
        Arrays.sort(map, (a, b) -> a[0] - b[0]);
        int n = 1;
        result[map[0][1]] = n;
        for (int i = 1; i < length; i++) {
            if (map[i][0] != map[i - 1][0])
                n++;
            result[map[i][1]] = n;
        }
        return result;
    }
}
