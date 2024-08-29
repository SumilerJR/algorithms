// 38. 二叉树的镜像 - AcWing题库
// https://www.acwing.com/problem/content/37/
// 剑指 Offer 27. 二叉树的镜像 - 力扣（Leetcode）
// https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/
// 226. 翻转二叉树 - 力扣（Leetcode）
// https://leetcode.cn/problems/invert-binary-tree/
class Solution {
    public void mirror(TreeNode root) {
        flip(root);
    }

    public TreeNode flip(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        flip(root.left);
        flip(root.right);
        return root;
    }
}