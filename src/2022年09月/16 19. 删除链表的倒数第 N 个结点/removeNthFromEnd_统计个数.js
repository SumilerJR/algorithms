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
 * 执行用时：72 ms, 在所有 JavaScript 提交中击败了17.80%的用户
 * 内存消耗：41.7 MB, 在所有 JavaScript 提交中击败了34.51%的用户
 * 双遍历
 */
var removeNthFromEnd = function (head, n) {
    let cur = head, m = 0;
    while (cur !== null) {
        cur = cur.next;
        m++;
    }
    if (m === n) {
        return head.next;
    }
    cur = head;
    for (let i = 0; i < m - n - 1; i++) {
        cur = cur.next;
    }
    cur.next = cur.next.next;
    return head;
};