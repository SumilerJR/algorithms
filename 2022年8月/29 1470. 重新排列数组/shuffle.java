class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        for (int k = 0, i = 0, j = n; i < n; i++, j++) {
            ans[k++] = nums[i];
            ans[k++] = nums[j];
        }
        return ans;
    }
}