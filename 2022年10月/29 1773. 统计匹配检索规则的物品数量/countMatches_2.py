class Solution(object):
    def countMatches(self, items, ruleKey, ruleValue):
        """
        :type items: List[List[str]]
        :type ruleKey: str
        :type ruleValue: str
        :rtype: int
        执行用时：44 ms, 在所有 Python 提交中击败了62.86%的用户
        内存消耗：17.6 MB, 在所有 Python 提交中击败了28.57%的用户
        """
        # return len(
        #     filter(
        # 用字典的形式取出对应下标的值，骚操作
        #         lambda item: item[{"type": 0, "color": 1, "name": 2}[ruleKey]]
        #         == ruleValue,
        #         items,
        #     )
        # )

        return sum(
            # 1是指符合if判断的时候取出的值，都为1是为了累加sum求个数，也可以将迭代器转为list后用len取长度
            1
            for t, c, n in items
            if {"type": t, "color": c, "name": n}[ruleKey] == ruleValue
        )
