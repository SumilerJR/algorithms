import java.util.*;


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

//执行用时：13 ms, 在所有 Java 提交中击败了95.94%的用户
//内存消耗：51.7 MB, 在所有 Java 提交中击败了11.25%的用户
class Solution {
    Set<TreeNode> set = new HashSet<>();
    Map<String, TreeNode> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(set);
    }
    public String dfs(TreeNode root) {
        if (root == null)
            return "#";
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        sb.append(",");
        sb.append(dfs(root.left));
        sb.append(",");
        sb.append(dfs(root.right));
        String str = sb.toString();
        if (map.containsKey(str)) {
            set.add(map.get(str));
        } else {
            map.put(str, root);
        }
        return str;
    }
}