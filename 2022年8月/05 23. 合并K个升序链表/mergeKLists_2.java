// 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：43.2 MB, 在所有 Java 提交中击败了70.75%的用户
//  - 分治：两两合并
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size < 2)
            return size == 1 ? lists[0] : null;
        return mergeKLists(lists, 0, size - 1);
    }
    public ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low == high)
            return lists[low];
        if (low + 1 == high)
            return mergeTwoLists(lists[low], lists[high]);
        int mid = low + (high - low) / 2;
        return mergeTwoLists(mergeKLists(lists, low, mid), mergeKLists(lists, mid + 1, high));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode();
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return head.next;
    }
}