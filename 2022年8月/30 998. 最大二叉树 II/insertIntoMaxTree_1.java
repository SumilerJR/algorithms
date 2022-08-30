//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.9 MB, 在所有 Java 提交中击败了11.51%的用户
// - 中序遍历转为数组后再重新建树
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        list.add(val);
        return constructMaximumBinaryTree(list);
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
    }

    public TreeNode constructMaximumBinaryTree(List<Integer> list) {
        return constructMaximumBinaryTree(list, 0, list.size() - 1);
    }

    TreeNode constructMaximumBinaryTree(List<Integer> list, int left, int right) {
        if (left > right) return null;
        int index = findMax(list, left, right);
        TreeNode root = new TreeNode(list.get(index));
        root.left = constructMaximumBinaryTree(list, left, index - 1);
        root.right = constructMaximumBinaryTree(list, index + 1, right);
        return root;
    }

    int findMax(List<Integer> list, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (list.get(i) > list.get(maxIndex))
                maxIndex = i;
        }
        return maxIndex;
    }
}