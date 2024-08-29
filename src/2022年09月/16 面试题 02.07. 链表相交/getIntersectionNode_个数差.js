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
 * 内存消耗：48.1 MB, 在所有 JavaScript 提交中击败了67.05%的用户
 * 我们求出两个链表的长度，并求出两个链表长度的差值，然后让curA移动到，和curB 末尾对齐的位置，此时我们就可以比较curA和curB是否相同，如果不相同，同时向后移动curA和curB，如果遇到curA == curB，则找到交点。否则循环退出返回空指针。
 */
var getIntersectionNode = function (headA, headB) {
    let lengthA = getLength(headA);
    let lengthB = getLength(headB);
    if (lengthA > lengthB) {
        for (let i = 0; i < lengthA - lengthB; i++) {
            headA = headA.next;
        }
    } else {
        for (let i = 0; i < lengthB - lengthA; i++) {
            headB = headB.next;
        }
    }
    while (headA !== null) {
        if (headA === headB)
            return headA;
        headA = headA.next;
        headB = headB.next;
    }
    return null;
};

var getLength = function (head) {
    let count = 0;
    while (head !== null) {
        head = head.next;
        count++;
    }
    return count;
};