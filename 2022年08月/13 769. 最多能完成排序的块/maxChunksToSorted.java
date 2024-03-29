// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：38.9 MB, 在所有 Java 提交中击败了26.99%的用户
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                ans++;
        }
        return ans;
    }
}