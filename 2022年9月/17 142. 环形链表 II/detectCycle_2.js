/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 * 执行用时：76 ms, 在所有 JavaScript 提交中击败了61.19%的用户
 * 内存消耗：43.5 MB, 在所有 JavaScript 提交中击败了85.80%的用户
 */
var detectCycle = function (head) {
    let fast = head, slow = head;
    while (fast !== null && fast.next !== null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast === slow) {
            while (head !== fast) {
                head = head.next;
                fast = fast.next;
            }
            return head;
        }
    }
    return null;
};