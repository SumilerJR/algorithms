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
 * 执行用时：60 ms, 在所有 JavaScript 提交中击败了86.54%的用户
 * 内存消耗：43.4 MB, 在所有 JavaScript 提交中击败了15.78%的用户
 * 递归写法
 */
var reverseList = function (head) {
    return reverse(null, head);
};

var reverse = function (pre, cur) {
    if (cur === null)
        return pre;
    let temp = cur.next;
    cur.next = pre;
    return reverse(cur, temp);
};

// 从后往前翻转
var reverseList = function (head) {
    if (head === null)
        return null;
    if (head.next === null)
        return head;
    let last = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return last;
};
