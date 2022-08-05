// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：41.8 MB, 在所有 Java 提交中击败了6.74%的用户

// 合并到树1
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
// 新建一棵树
// 代码重复率有点高了……应该可以优化一下 

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }
    public TreeNode dfs(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        TreeNode node = new TreeNode();
        if (root1 == null) {
            node.val += root2.val;
            node.left = dfs(null, root2.left);
            node.right = dfs(null, root2.right);
        }
        else if (root2 == null) {
            node.val += root1.val;
            node.left = dfs(root1.left, null);
            node.right = dfs(root1.right, null);
        }
        else {
            node.val = root1.val + root2.val;
            node.left = dfs(root1.left, root2.left);
            node.right = dfs(root1.right, root2.right);
        }

        return node;
    }
}