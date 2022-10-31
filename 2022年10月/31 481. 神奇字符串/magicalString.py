class Solution(object):
    def magicalString(self, n):
        """
        :type n: int
        :rtype: int
        执行用时：120 ms, 在所有 Python 提交中击败了69.23%的用户
        内存消耗：13.1 MB, 在所有 Python 提交中击败了76.92%的用户
        """
        s = "122"
        i = 2
        while len(s) < n:
            if i % 2 == 0:
                s += "1" * int(s[i])  # 字符串的拼接（这里要转一下int）
            else:
                s += "2" * int(s[i])
            i += 1
        return s[:n].count("1")


class Solution(object):
    def magicalString(self, n):
        """
        :type n: int
        :rtype: int
        """
        s = [1, 2, 2]
        i = 2
        while len(s) < n:
            if i % 2 == 0:
                s += [1] * s[i]  # 列表的拼接要用列表乘以一个数
            else:
                s += [2] * s[i]
            i += 1
        return s[:n].count(1)
