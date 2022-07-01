//74. 搜索二维矩阵
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：40.9 MB, 在所有 Java 提交中击败了79.85%的用户
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int bot = row - 1 , top = 0;//底边界和顶边界
        int left = 0, right = col - 1;//左臂右臂
        while (top < bot) {//先搜索出哪行
            int mid = top + (bot - top) / 2;
            if (matrix[mid][col - 1] < target)
                top = mid + 1;
            else if (matrix[mid][col -  1] > target)
                bot = mid;
            else
                return true;//若最后一个元素刚好是target 则直接返回true
        }
        while (left <= right) {//在找到的一维数组里进行普通二分查找
            int mid = left + (right - left) / 2;
            if (matrix[top][mid] < target)
                left = mid + 1;
            else if (matrix[top][mid] > target)
                right = mid - 1;
            else
                return true;
        }
        return false;
    }
}
