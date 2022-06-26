// - 广搜更简单就没写了，试试深搜理清层数关系也不难
//执行用时：1 ms, 在所有 Java 提交中击败了93.73%的用户
//内存消耗：41.4 MB, 在所有 Java 提交中击败了89.79%的用户
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return list;
    }
    public void dfs(TreeNode root, int height) {
        if (root == null)
            return;
        if (list.size() <= height)
            list.add(root.val);
        else if (list.get(height) < root.val)
            list.set(height, root.val);
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}
