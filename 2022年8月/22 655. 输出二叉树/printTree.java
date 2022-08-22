//执行用时：1 ms, 在所有 Java 提交中击败了90.51%的用户
//内存消耗：42.1 MB, 在所有 Java 提交中击败了5.06%的用户
// 递归
class Solution {
    int height, m, n;
    public List<List<String>> printTree(TreeNode root) {
        height = getHeight(root) - 1;
        m = height + 1;
        n = (1 << height + 1) - 1;
        List<List<String>> res = new ArrayList<>();
        String[][] map = new String[m][n];
        printTree(root, map, 0, (n - 1) / 2);
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(map[i][j] == null ? "" : map[i][j]);
            }
            res.add(list);
        }
        return res;
    }

    void printTree(TreeNode root, String[][] map, int row, int col) {
        if (root == null)
            return;
        map[row][col] = String.valueOf(root.val);
        printTree(root.left, map, row + 1, col - (1 << (height - row - 1)));
        printTree(root.right, map, row + 1, col + (1 << (height - row - 1)));
    }

    int getHeight(TreeNode root) {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}


//执行用时：1 ms, 在所有 Java 提交中击败了90.51%的用户
//内存消耗：41.5 MB, 在所有 Java 提交中击败了75.32%的用户
class Solution {
    int height, m, n;
    public List<List<String>> printTree(TreeNode root) {
        height = getHeight(root) - 1;
        m = height + 1;
        n = (1 << height + 1) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }
        printTree(root, res, 0, (n - 1) / 2);
        return res;
    }

    void printTree(TreeNode root, List<List<String>> res, int row, int col) {
        if (root == null)
            return;
        res.get(row).set(col, String.valueOf(root.val));
        printTree(root.left, res, row + 1, col - (1 << (height - row - 1)));
        printTree(root.right, res, row + 1, col + (1 << (height - row - 1)));
    }

    int getHeight(TreeNode root) {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}