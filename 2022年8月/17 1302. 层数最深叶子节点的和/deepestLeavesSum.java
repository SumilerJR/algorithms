//执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：43.9 MB, 在所有 Java 提交中击败了41.18%的用户
class Solution {
    int maxHeight = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        help(root, 0);
        return sum;
    }

    public void help(TreeNode root, int height) {
        if (root == null)
            return;
        if (height > maxHeight) {
            maxHeight = height;
            sum = root.val;
        }
        else if (height == maxHeight){
            sum += root.val;
        }
        help(root.left, height + 1);
        help(root.right, height + 1);
    }
}


//执行用时：2 ms, 在所有 Java 提交中击败了69.28%的用户
//内存消耗：44.4 MB, 在所有 Java 提交中击败了6.54%的用户
class Solution {
    int maxHeight;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        maxHeight = getHeight(root);
        deepestLeavesSum(root, 1);
        return sum;
    }

    public void deepestLeavesSum(TreeNode root, int height) {
        if (root == null)
            return;
        if (height == maxHeight)
            sum += root.val;
        else {
            deepestLeavesSum(root.left, height + 1);
            deepestLeavesSum(root.right, height + 1);
        }
    }

    public int getHeight(TreeNode root) {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

//执行用时：7 ms, 在所有 Java 提交中击败了17.12%的用户
//内存消耗：43.8 MB, 在所有 Java 提交中击败了51.64%的用户
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int sum = 0;
        while (!deque.isEmpty()) {
            sum = 0;
            int size = deque.size();
            while (size-- > 0) {
                root = deque.poll();
                sum += root.val;
                if (root.left != null)
                    deque.offer(root.left);
                if (root.right != null)
                    deque.offer(root.right);
            }
        }
        return sum;
    }
}