// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：39 MB, 在所有 Java 提交中击败了100.00%的用户
class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i != 0)
                set.add(i);
        }
        return set.size();
    }
}
