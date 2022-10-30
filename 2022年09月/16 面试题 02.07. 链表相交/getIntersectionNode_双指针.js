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
 * 执行用时：108 ms, 在所有 JavaScript 提交中击败了8.83%的用户
 * 内存消耗：48.2 MB, 在所有 JavaScript 提交中击败了55.79%的用户
 * a + c + b = b + c + a
 * 若无交集，则a + b = b + a
 * 简单的来说，就是让两个指针在两条链表都走一次，这样会在各自走第二条链表时相遇退出循环从而返回指针指向的节点，要不就都指向空返回null说明没有相交
 */
var getIntersectionNode = function (headA, headB) {
    let h1 = headA, h2 = headB;
    while (h1 !== h2) {
        h1 = h1 === null ? headB : h1.next;
        h2 = h2 === null ? headA : h2.next;
    }
    return h1;
};