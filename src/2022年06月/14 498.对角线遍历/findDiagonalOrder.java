// 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：43 MB, 在所有 Java 提交中击败了72.21%的用户

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] result = new int[row * col];
        int count = 0;
        for(int i = 0; i < row + col - 1; i++){
            if(i % 2 == 0) {//为斜向上遍历
                int x = i < row ? i : row - 1;//取i值或者为边界值
                int y = i < row ? 0 : i - row + 1;//取0或者为边界值
                while (x >= 0 && y < col){
                    result[count++] = mat[x--][y++];
                }
            }
            else {//为斜向下遍历
                int x = i < col ? 0 : i - col + 1;//取0或者为边界值
                int y = i < col ? i : col - 1;//取i或者为边界值
                while (x < row && y >= 0){
                    result[count++] = mat[x++][y--];
                }
            }
        }
        return result;
    }
}