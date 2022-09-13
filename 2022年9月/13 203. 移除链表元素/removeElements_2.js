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
 * 使用虚头结点——之前的写法
 * 执行用时：64 ms, 在所有 JavaScript 提交中击败了97.95%的用户
 * 内存消耗：45.5 MB, 在所有 JavaScript 提交中击败了66.53%的用户
 *  */
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}
var removeElements = function (head, val) {
    let node = new ListNode();
    node.next = head;
    let cur = node;
    while (head !== null) {
        if (head.val === val) {
            cur.next = null;
        } else {
            cur.next = head;
            cur = cur.next;
        }
        head = head.next;
    }
    return node.next;
};