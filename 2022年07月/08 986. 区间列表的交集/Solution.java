//执行用时：3 ms, 在所有 Java 提交中击败了90.55%的用户
//内存消耗：42.4 MB, 在所有 Java 提交中击败了15.98%的用户
//  - 双指针
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int []> list = new ArrayList<>();
        int l1 = firstList.length, l2 = secondList.length;//两个数组长度
        for (int i = 0, j = 0; i < l1 && j < l2;) {
            int[] temp = {//取交集，即左臂取大，右臂取小
                    Math.max(firstList[i][0], secondList[j][0]),
                    Math.min(firstList[i][1], secondList[j][1])};
            if (temp[0] <= temp[1])
                list.add(temp);//要符合左小于等于右的才是有效区间
            if (firstList[i][1] < secondList[j][1])
                i++;//移动右臂数值较小的数组指针
            else
                j++;

        }
        return list.toArray(new int[list.size()][]);
    }
}
