//执行用时：2 ms, 在所有 Java 提交中击败了83.63%的用户
//内存消耗：41.5 MB, 在所有 Java 提交中击败了49.99%的用户
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int index = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, left, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, right);
        return root;
    }

    int findMax(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
}
