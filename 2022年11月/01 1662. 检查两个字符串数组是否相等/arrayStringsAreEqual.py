class Solution(object):
    def arrayStringsAreEqual(self, word1, word2):
        """
        :type word1: List[str]
        :type word2: List[str]
        :rtype: bool
        执行用时：16 ms, 在所有 Python 提交中击败了75.93%的用户
        内存消耗：13 MB, 在所有 Python 提交中击败了68.52%的用户
        """
        return "".join(word1) == "".join(word2)