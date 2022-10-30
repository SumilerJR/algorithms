//执行用时：3 ms, 在所有 Java 提交中击败了98.65%的用户
//内存消耗：57.5 MB, 在所有 Java 提交中击败了51.74%的用户
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode root = new ListNode();
        root.next = head;
        ListNode slow = root, fast = root;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow, post = slow.next;
        slow = slow.next;
//        ListNode post = slow.next;
        while (slow != null) {
            post = post.next;
            slow.next = pre;
            pre = slow;
            slow = post;
//            post = post == null ? null : post.next;
        }
        ListNode left = head, right = pre;
        while (left != right) {
            if (left.val != right.val)
                return false;
            if (left.next == right)
                break;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
