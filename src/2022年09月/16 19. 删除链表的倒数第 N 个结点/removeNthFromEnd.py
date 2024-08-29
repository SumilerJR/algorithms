# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# 执行用时：24 ms, 在所有 Python3 提交中击败了99.75%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了94.47%的用户
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        head_dummy = ListNode()
        head_dummy.next = head
        slow, fast = head_dummy, head_dummy
        while (n != 0):
            fast = fast.next
            n -= 1
        while (fast.next != None):
            slow = slow.next
            fast = fast.next
        slow.next = slow.next.next
        return head_dummy.next