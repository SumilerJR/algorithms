//执行用时：5 ms, 在所有 Java 提交中击败了61.48%的用户
//内存消耗：58 MB, 在所有 Java 提交中击败了24.30%的用户
// - 这题如果用原地算法其实就是链表的中间节点+翻转链表两题结合的应用，很有意思~！
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = middleNode(head);//获取中间节点
        ListNode lastNode = reverseList(midNode);//从中间节点开始反转链表
        ListNode left = head, right = lastNode;//左右双指针
        boolean flag = true;//标记
        while (flag && right != null) {
            if (left.val != right.val)
                flag = false;
            left = left.next;
            right = right.next;
        }
        midNode.next = reverseList(lastNode);//复原原链表
        return flag;
    }

//   876. 链表的中间结点：https://leetcode.cn/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

//   206. 反转链表：https://leetcode.cn/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
