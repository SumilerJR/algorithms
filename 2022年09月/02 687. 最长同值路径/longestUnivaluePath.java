
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0, count = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.val == root.left.val) {
            ans = left + 1;
            count += left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            ans = Math.max(ans, right + 1);
            count += right + 1;
        }
        max = Math.max(max, count);
        return ans;
    }
}