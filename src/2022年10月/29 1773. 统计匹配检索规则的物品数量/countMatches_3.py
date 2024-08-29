class Solution(object):
    def countMatches(self, items, ruleKey, ruleValue):
        """
        :type items: List[List[str]]
        :type ruleKey: str
        :type ruleValue: str
        :rtype: int
        执行用时：36 ms, 在所有 Python 提交中击败了100.00%的用户
        内存消耗：17.3 MB, 在所有 Python 提交中击败了97.14%的用户
        """
        count, index = 0, 0 if ruleKey[0] == "t" else 1 if ruleKey[0] == "c" else 2
        for item in items:
            if item[index] == ruleValue:
                count += 1
        return count
