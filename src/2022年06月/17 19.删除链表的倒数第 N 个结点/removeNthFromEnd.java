// 复习了离散，吃饭前做一道题，提交完发现是做过的……再次学习吧
// 快慢指针单遍历

// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：39.5 MB, 在所有 Java 提交中击败了59.33%的用户

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;//快慢指针
        for(int i = 0; i < n; i++)
            fast = fast.next;//快指针先走n步
        if(fast == null)//若快指针走了n步后为null，说明删除的是头结点
            return head.next;//因此返回head.next即可
        while (fast.next != null) {//快指针走到最后一个节点为止
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;//删除慢指针的下一个节点
        return head;
    }
}
// 设置头结点 + 单指针计数双遍历

// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：39.5 MB, 在所有 Java 提交中击败了59.33%的用户

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode();//设置头结点
        node.next = head;
        head = node;
        int count = 0;
        while(head.next != null) {
            head = head.next;
            count++;
        }
        head = node;
        while(count-- > n)
            head = head.next;
        head.next = head.next.next;
        return node.next;
    }
}