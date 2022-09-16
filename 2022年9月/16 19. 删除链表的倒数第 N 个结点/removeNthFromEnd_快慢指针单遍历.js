/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 * 执行用时：56 ms, 在所有 JavaScript 提交中击败了92.32%的用户
 * 内存消耗：41.6 MB, 在所有 JavaScript 提交中击败了63.86%的用户
 * 单遍历
 */
var removeNthFromEnd = function (head, n) {
    let slow = head, fast = head;
    for (let i = 0; i < n; i++) {
        fast = fast.next;
    }
    if (fast === null)
        return head.next;
    while (fast.next !== null) {
        slow = slow.next;
        fast = fast.next;
    }
    slow.next = slow.next.next;
    return head;
};