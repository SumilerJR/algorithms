// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：41.4 MB, 在所有 Java 提交中击败了59.77%的用户
class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null)//为空或为叶子
            return root;
        root.left.next = root.right;//左连右
        if(root.next != null)//有兄弟节点
            root.right.next = root.next.left;//右连兄弟节点的左
        connect(root.left);//递归连接
        connect(root.right);
        return root;
    }
}
