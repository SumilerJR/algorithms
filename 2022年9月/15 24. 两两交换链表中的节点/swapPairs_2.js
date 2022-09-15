/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 * 执行用时：56 ms, 在所有 JavaScript 提交中击败了87.72%的用户
 * 内存消耗：41.5 MB, 在所有 JavaScript 提交中击败了11.09%的用户
 */
var swapPairs = function (head) {
    if (head === null || head.next === null)
        return head;
    let next = head.next;
    head.next = swapPairs(next.next);
    next.next = head;
    return next;
};