/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 * 不使用虚头结点
 * 执行用时：100 ms, 在所有 JavaScript 提交中击败了5.64%的用户
 * 内存消耗：45.1 MB, 在所有 JavaScript 提交中击败了92.68%的用户 */
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}
var removeElements = function (head, val) {
    while (head !== null && head.val === val) {
        head = head.next;
    }
    let cur = head;
    while (cur !== null && cur.next !== null) {
        if (cur.next.val === val) {
            cur.next = cur.next.next;
        } else {
            cur = cur.next;
        }
    }
    return head;
};