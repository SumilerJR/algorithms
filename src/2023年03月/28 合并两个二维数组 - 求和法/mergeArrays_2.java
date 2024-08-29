import java.util.ArrayList;

// 2570. 合并两个二维数组 - 求和法 - 力扣（Leetcode）
// https://leetcode.cn/problems/merge-two-2d-arrays-by-summing-values/solutions/
//归并排序
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int l1 = nums1.length, l2 = nums2.length;
        for (int i = 0, j = 0; i < l1 || j < l2;) {
            if (i >= l1) {
                list.add(nums2[j++]);
            } else if (j >= l2) {
                list.add(nums1[i++]);
            } else if (nums1[i][0] < nums2[j][0]) {
                list.add(nums1[i++]);
            } else if (nums2[j][0] < nums1[i][0]) {
                list.add(nums2[j++]);
            } else {
                list.add(new int[] { nums1[i][0], nums1[i++][1] + nums2[j++][1] });
            }
        }
        return list.toArray(new int[list.size()][]);// list转数组
    }
}