// 久违的链表题  做简单题好舒服，写完继续复习离散

// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：38.9 MB, 在所有 Java 提交中击败了50.77%的用户

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){//或者直接保持快指针当前及下一个都不为空
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null) {
            fast =  fast.next;
            if (fast == null)
                break;
            slow = slow.next;//把这步放到if后面，避免奇偶个节点的繁琐问题
            fast = fast.next;
        }
        return slow;
    }
}