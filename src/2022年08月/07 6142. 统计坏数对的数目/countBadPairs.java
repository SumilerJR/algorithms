// 执行用时：31 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：49.3 MB, 在所有 Java 提交中击败了100.00%的用户
class Solution {
    public long countBadPairs(int[] nums) {
        long count = 0;
        long length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] - i;
        }
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                count += map.get(nums[i]);
            }
            else
                map.put(nums[i], 0);
        }
        return length * (length - 1) / 2 - count;
    }
}