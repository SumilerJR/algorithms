//执行用时：2 ms, 在所有 Java 提交中击败了94.44%的用户
//内存消耗：42.3 MB, 在所有 Java 提交中击败了19.22%的用户
class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
