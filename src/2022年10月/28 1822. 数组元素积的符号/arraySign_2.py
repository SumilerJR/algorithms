from functools import reduce


class Solution(object):
    def arraySign(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        执行用时：20 ms, 在所有 Python 提交中击败了65.42%的用户
        内存消耗：13 MB, 在所有 Python 提交中击败了82.24%的用户
        """
        res = reduce(lambda x, y: x * y, nums)
        if res == 0:
            return 0
        elif res > 0:
            return 1
        else:
            return -1
