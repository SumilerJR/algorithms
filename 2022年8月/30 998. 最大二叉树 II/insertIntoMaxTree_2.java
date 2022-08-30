//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.2 MB, 在所有 Java 提交中击败了98.92%的用户
// - 利用建树规则，一直往右找，新增节点一定是别人的右孩子，自己可能有左孩子，一定没有右孩子
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            return new TreeNode(val, root, null);
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}

