/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 * 执行用时：88 ms, 在所有 JavaScript 提交中击败了57.25%的用户
 * 内存消耗：49.2 MB, 在所有 JavaScript 提交中击败了10.96%的用户
 */
var getIntersectionNode = function (headA, headB) {
    const set = new Set();
    while (headA !== null) {
        set.add(headA);
        headA = headA.next;
    }
    while (headB !== null) {
        if (set.has(headB))
            return headB;
        headB = headB.next;
    }
    return null;
};