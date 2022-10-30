//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：40.8 MB, 在所有 Java 提交中击败了91.26%的用户
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return null;
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        }
        else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }
}