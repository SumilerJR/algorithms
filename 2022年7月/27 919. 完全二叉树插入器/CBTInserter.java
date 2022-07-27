/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//执行用时：13 ms, 在所有 Java 提交中击败了99.74%的用户
//内存消耗：42.1 MB, 在所有 Java 提交中击败了48.90%的用户
class CBTInserter {
    TreeNode root;
    Deque<TreeNode> deque;
    public CBTInserter(TreeNode root) {
        deque = new ArrayDeque<>();
        this.root = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                root = queue.poll();
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
                if (root.left == null || root. right == null)
                    deque.offerLast(root);
            }
        }
    }

    public int insert(int val) {
        TreeNode cur = deque.pollFirst();
        if (cur.left == null) {
            cur.left = new TreeNode(val);
            deque.offerLast(cur.left);
            deque.offerFirst(cur);
        }
        else {
            cur.right = new TreeNode(val);
            deque.offerLast(cur.right);
        }
        return cur.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
