//执行用时：5 ms, 在所有 Java 提交中击败了99.98%的用户
//内存消耗：42 MB, 在所有 Java 提交中击败了88.25%的用户
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
