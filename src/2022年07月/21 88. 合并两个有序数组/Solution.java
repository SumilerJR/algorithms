// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：41.3 MB, 在所有 Java 提交中击败了54.49%的用户
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int i = m + n - 1;
        while (i >= 0 && index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2])
                nums1[i] = nums1[index1--];
            else
                nums1[i] = nums2[index2--];
            i--;
        }
        while (index1 >= 0)
            nums1[i--] = nums1[index1--];
        while (index2 >= 0)
            nums1[i--] = nums2[index2--];
    }
}
