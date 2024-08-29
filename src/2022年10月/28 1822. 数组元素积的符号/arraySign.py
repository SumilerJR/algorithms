class Solution(object):
    def arraySign(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        执行用时：20 ms, 在所有 Python 提交中击败了65.42%的用户
        内存消耗：13 MB, 在所有 Python 提交中击败了79.44%的用户
        """
        if 0 in nums:
            return 0
        elif len(filter(lambda x: x < 0, nums)) % 2 == 1:
            return -1
        else:
            return 1
