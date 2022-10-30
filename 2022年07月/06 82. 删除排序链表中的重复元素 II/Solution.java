// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：40.9 MB, 在所有 Java 提交中击败了62.50%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;//为空或为独立节点时无需删除
        ListNode post = new ListNode();//哑头结点
        ListNode slow = post, fast = head;//快慢指针
        while (fast != null) {//快指针走在前 不为空则一直走
            if (fast.next != null && fast.val == fast.next.val) {//遇到重复节点时，进入跳过环节
                while (fast.next != null && fast.val == fast.next.val){
                    fast = fast.next;//快指针走到最后一个重复节点上
                }
            }
            else {
                slow.next = fast;//不为重复节点则用慢指针连上
                slow = slow.next;//记得慢指针也要走一步
            }
            fast = fast.next;//快指针不管是否为重复节点都要走一步，是重复节点时可以从最后一个重复节点走出来
        }
        slow.next = null;//慢指针最后为空，防止快指针走过了但没删除掉
        return post.next;//返回哑头结点的下一个节点
    }
}
