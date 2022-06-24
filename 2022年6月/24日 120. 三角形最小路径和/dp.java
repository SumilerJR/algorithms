// - 自底向上 无额外空间
//执行用时：9 ms, 在所有 Java 提交中击败了7.70%的用户
//内存消耗：41 MB, 在所有 Java 提交中击败了53.98%的用户
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int temp = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + temp);
            }
        }
        return triangle.get(0).get(0);
    }
}

// - 自顶向下 空间优化为一维数组
//执行用时：2 ms, 在所有 Java 提交中击败了95.88%的用户
//内存消耗：41 MB, 在所有 Java 提交中击败了52.77%的用户
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        if (height == 1)
            return triangle.get(0).get(0);
        if (height == 2)
            return Math.min(triangle.get(1).get(0), triangle.get(1).get(1)) + triangle.get(0).get(0);
        int[] dp = new int[height];
        dp[0] = triangle.get(0).get(0) + triangle.get(1).get(0);
        dp[1] = triangle.get(0).get(0) + triangle.get(1).get(1);
        for (int i = 2; i < height; i++) {
            //一维数组dp时要转换一下 由于共用一个数组 逻辑上要改为从右往左遍历
            dp[i] = dp[i - 1] + triangle.get(i).get(i);//因此先把上一层最右元素赋值
            for (int j = i; j >= 1; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                //从右往左遍历赋值
            }
            dp[0] = dp[0] + triangle.get(i).get(0);//最后把第一个元素赋值
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }
}

// - 动态规划 自顶向下
//执行用时：3 ms, 在所有 Java 提交中击败了77.26%的用户
//内存消耗：41.3 MB, 在所有 Java 提交中击败了11.11%的用户
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        if (height == 1)
            return triangle.get(0).get(0);
        if (height == 2)
            return Math.min(triangle.get(1).get(0), triangle.get(1).get(1)) + triangle.get(0).get(0);
        int[][] dp = new int[height][];
        dp[0] = new int[]{triangle.get(0).get(0)};//dp数组初始化
        dp[1] = new int[]{triangle.get(1).get(0) + dp[0][0], triangle.get(1).get(1) + dp[0][0]};
        for (int i = 2; i < height; i++) {
            dp[i] = new int[i + 1];
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];//首个直接赋值
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                //递推公式：min(上一层当前坐标元素，上一层当前坐标-1元素) + 当前层当前坐标元素
            }
            dp[i][i] = triangle.get(i).get(i) + dp[i -1][i - 1];//最后一个也直接赋值
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[height - 1].length; i++) {
            min = Math.min(dp[height - 1][i], min);
        }
        return min;
    }
}
