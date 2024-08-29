class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        执行用时：20 ms, 在所有 Python 提交中击败了63.39%的用户
        内存消耗：13.3 MB, 在所有 Python 提交中击败了21.95%的用户
        """
        return list(set(nums1) & set(nums2))