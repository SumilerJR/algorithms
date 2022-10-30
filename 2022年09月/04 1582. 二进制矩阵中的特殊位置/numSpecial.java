class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && help(mat, i, j))
                    count++;
            }
        }
        return count;
    }
    public boolean help(int[][] mat, int x, int y) {
        for (int i = 0; i < mat.length; i++) {
            if (i != x && mat[i][y] == 1)
                return false;
        }
        for (int i = 0; i < mat[0].length; i++) {
            if (i != y && mat[x][i] == 1)
                return false;
        }
        return true;
    }
}


class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1)
                    count++;
            }
        }
        return count;
    }
}