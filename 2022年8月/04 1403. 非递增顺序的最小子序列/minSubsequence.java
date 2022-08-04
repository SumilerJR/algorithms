// 执行用时：3 ms, 在所有 Java 提交中击败了95.47%的用户
// 内存消耗：41.4 MB, 在所有 Java 提交中击败了81.30%的用户
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0, resultSum = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i : nums) {
            sum += i;
        }
        for (int i = length - 1; resultSum <= sum && i >= 0; i--) {
            list.add(nums[i]);
            resultSum += nums[i];
            sum -= nums[i];
        }
        return list;
    }
}