// - 层序是从左到右，反过来从右到左最后一个节点就是符合题目最深最左的节点了
//执行用时：1 ms, 在所有 Java 提交中击败了63.15%的用户
//内存消耗：40.9 MB, 在所有 Java 提交中击败了66.17%的用户
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.offer(root.right);
            if (root.left != null)
                queue.offer(root.left);
        }
        return root.val;
    }
}

// - 常规写法写一遍，一个指针的空间开销
//执行用时：1 ms, 在所有 Java 提交中击败了63.15%的用户
//内存消耗：41.5 MB, 在所有 Java 提交中击败了6.06%的用户
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode first = root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            first = queue.peek();
            while (size-- > 0) {
                root = queue.poll();
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
        }
        return first.val;
    }
}
