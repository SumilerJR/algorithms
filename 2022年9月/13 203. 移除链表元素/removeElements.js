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
 * 使用虚头结点——现在的写法
 * 执行用时：84 ms, 在所有 JavaScript 提交中击败了24.15%的用户
 * 内存消耗：45.6 MB, 在所有 JavaScript 提交中击败了39.52%的用户
 */
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}
var removeElements = function (head, val) {
    let node = new ListNode();
    node.next = head;
    let cur = node;
    while (cur !== null) {
        if (cur.next !== null && cur.next.val === val) {
            cur.next = cur.next.next;
        } else {
            cur = cur.next;
        }
    }
    return node.next;
};