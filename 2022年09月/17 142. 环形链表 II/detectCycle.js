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
 * 执行用时：88 ms, 在所有 JavaScript 提交中击败了13.79%的用户
 * 内存消耗：44.1 MB, 在所有 JavaScript 提交中击败了8.35%的用户
 */
var detectCycle = function (head) {
    let set = new Set();
    while (head !== null) {
        if (set.has(head)) {
            return head;
        }
        set.add(head);
        head = head.next;
    }
    return null;
};