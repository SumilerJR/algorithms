// - 利用前序遍历每一层第一次访问的一定是最左边的节点这一特点，加个深度判断即可
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：40.9 MB, 在所有 Java 提交中击败了70.78%的用户
class Solution {
    int maxDepth = -1;
    int res;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs (TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth > maxDepth) {//大于最大深度，即为新的一层
            maxDepth = depth;//更新最大深度
            res = root.val;//更新最深最左值
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
