// 执行用时：2 ms, 在所有 Java 提交中击败了69.83%的用户
// 内存消耗：41.7 MB, 在所有 Java 提交中击败了23.63%的用户

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node cur = root;
        Node pre;//上一个节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(cur);
        while(!queue.isEmpty()) {
            pre = null;
            int size = queue.size();
            while(size-- > 0) {
                cur = queue.poll();
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
                if(pre == null)//当前层第一个节点
                    pre = cur;
                else {//不为首节点则进行连接操作
                    pre.next = cur;
                    pre = pre.next;
                }
            }
        }
        return root;
    }
}
