class Solution(object):
    def kthGrammar(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        执行用时：20 ms, 在所有 Python 提交中击败了55.56%的用户
        内存消耗：13 MB, 在所有 Python 提交中击败了77.78%的用户
        """
        if n == 1:
            return 0
        mid = 2 ** (n - 2)
        if k <= mid:
            return self.kthGrammar(n - 1, k)
        else:
            return 1 ^ self.kthGrammar(n - 1, k - mid)