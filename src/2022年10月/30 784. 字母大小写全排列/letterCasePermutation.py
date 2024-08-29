class Solution(object):
    def letterCasePermutation(self, s):
        """
        :type s: str
        :rtype: List[str]
        执行用时：48 ms, 在所有 Python3 提交中击败了58.90%的用户
        内存消耗：16.4 MB, 在所有 Python3 提交中击败了31.74%的用户
        """
        res = list()
        l = len(s)

        def dfs(index, temp):
            if index == l:
                res.append("".join(temp))
            elif temp[index].isdigit():
                dfs(index + 1, temp)
            else:
                temp[index] = temp[index].swapcase()  # 大小写转换
                dfs(index + 1, temp)
                temp[index] = temp[index].swapcase()
                dfs(index + 1, temp)

        dfs(0, list(s))
        return res
