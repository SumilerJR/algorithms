<!--
 * @Author: 九日 mail@sumiler.com
 * @Date: 2022-08-02 16:31:45
 * @LastEditors: 九日 mail@sumiler.com
 * @LastEditTime: 2023-10-28 16:52:58
 * @FilePath: \LeetCode\README.md
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
记录数据结构与算法的内容，主要是算法题和一些以注释和md的笔记

## 2022年9月8日

### 904 水果成篮

 - 滑动窗口

 1. 最小滑窗模板：给定数组 nums，定义滑窗的左右边界 i, j，求满足某个条件的滑窗的最小长度。
 ```js
 while j < len(nums):
    判断[i, j]是否满足条件
    while 满足条件：
        不断更新结果(注意在while内更新！)
        i += 1 （最大程度的压缩i，使得滑窗尽可能的小）
    j += 1
```

2. 最大滑窗模板：给定数组 nums，定义滑窗的左右边界 i, j，求满足某个条件的滑窗的最大长度。
```js
while j < len(nums):
    判断[i, j]是否满足条件
    while 不满足条件：
        i += 1 （最保守的压缩i，一旦满足条件了就退出压缩i的过程，使得滑窗尽可能的大）
    不断更新结果（注意在while外更新！）
    j += 1
```

关键的区别在于，最大滑窗是在迭代右移右边界的过程中更新结果，而最小滑窗是在迭代右移左边界的过程中更新结果。因此虽然都是滑窗，但是两者的模板和对应的贪心思路并不一样，而真正理解后就可以在lc.76，lc.904，lc.3, lc.1004写出非常无脑的代码。

作者：frostep


