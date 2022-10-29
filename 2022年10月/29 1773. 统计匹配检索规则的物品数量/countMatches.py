class Solution(object):
    def countMatches(self, items, ruleKey, ruleValue):
        """
        :type items: List[List[str]]
        :type ruleKey: str
        :type ruleValue: str
        :rtype: int
        执行用时：48 ms, 在所有 Python 提交中击败了40.00%的用户
        内存消耗：17.3 MB, 在所有 Python 提交中击败了91.43%的用户
        """
        count = 0
        for item in items:
            if ruleKey == "type" and ruleValue == item[0]:
                count += 1
            elif ruleKey == "color" and ruleValue == item[1]:
                count += 1
            elif ruleKey == "name" and ruleValue == item[2]:
                count += 1
        return count
