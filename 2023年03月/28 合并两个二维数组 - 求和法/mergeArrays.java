
// 2570. 合并两个二维数组 - 求和法 - 力扣（Leetcode）
// https://leetcode.cn/problems/merge-two-2d-arrays-by-summing-values/solutions/
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] map = new int[1010];
        int size = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (map[nums1[i][0]] == 0) {
                size++;
            }
            map[nums1[i][0]] += nums1[i][1];
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map[nums2[i][0]] == 0) {
                size++;
            }
            map[nums2[i][0]] += nums2[i][1];
        }
        int[][] res = new int[size][2];
        int index = 0;
        for (int i = 0; i < 1010; i++) {
            if (map[i] != 0) {
                res[index][0] = i;
                res[index][1] = map[i];
                index++;
            }
        }
        return res;
    }
}