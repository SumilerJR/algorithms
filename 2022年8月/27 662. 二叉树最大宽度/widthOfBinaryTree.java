//执行用时：1 ms, 在所有 Java 提交中击败了99.78%的用户
//内存消耗：41.1 MB, 在所有 Java 提交中击败了41.31%的用户
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        return DFS(root, 1, 1);
    }
    public int DFS(TreeNode root, int depth, int index) {
        if (root == null)
            return 0;
        map.putIfAbsent(depth, index);
        int w = Math.max(DFS(root.left, depth + 1, index * 2), DFS(root.right, depth + 1, index * 2 + 1));
        return Math.max(index - map.get(depth) + 1, w);
    }
}

//执行用时：1 ms, 在所有 Java 提交中击败了99.78%的用户
//内存消耗：41.5 MB, 在所有 Java 提交中击败了5.58%的用户
class Tree {
    TreeNode node;
    int index;
    Tree(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Deque<Tree> deque = new LinkedList<>();
        deque.offerLast(new Tree(root, 1));
        while (!deque.isEmpty()) {
            ans = Math.max(ans, deque.getLast().index - deque.getFirst().index + 1);
            int size = deque.size();
            while (size-- > 0) {
                Tree cur = deque.pollFirst();
                if (cur.node.left != null)
                    deque.offerLast(new Tree(cur.node.left, cur.index * 2));
                if (cur.node.right != null)
                    deque.offerLast(new Tree(cur.node.right, cur.index * 2 + 1));
            }
        }
        return ans;
    }
}