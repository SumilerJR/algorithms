class Solution {
    public int amountOfTime(TreeNode root, int start) {
        int[][] map = new int[100010][3];
        boolean[] flag = new boolean[100010];
        build(root, 0, map);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        flag[start] = true;
        flag[0] = true;
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int k = queue.poll();
                for (int i = 0; i < 3; i++) {
                    if (!flag[map[k][i]]) {
                        queue.offer(map[k][i]);
                        flag[map[k][i]] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }
    public int build(TreeNode root, int p, int[][] map) {
        if (root == null)
            return 0;
        map[root.val][0] = p;
        map[root.val][1] = build(root.left,root.val, map);
        map[root.val][2] = build(root.right,root.val, map);
        return root.val;

    }
}