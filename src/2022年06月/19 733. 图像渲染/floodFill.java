// 做过的题，用广搜写一遍，效率比深搜低呀，不过感觉手写简单广搜深搜没啥问题了
// 深度优先搜索
class Solution {
    int[][] direction = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color)
            dfs(image, sr, sc,image[sr][sc], color);
        return image;
    }
    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if(x < 0 || x > image.length - 1 || y < 0 || y > image[0].length - 1 || image[x][y] != color)
            return;
        image[x][y] = newColor;
        for(int[] dir : direction) {
            dfs(image, x + dir[0], y + dir[1] , color, newColor);
        }
    }
}
// 广度优先搜索
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        int row = image.length, col = image[0].length;
        int[][] direction = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int target = image[sr][sc];
        image[sr][sc] = color;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] position = queue.poll();
                for(int[] dir : direction) {
                    int x = position[0] + dir[0], y = position[1] + dir[1];
                    if(x < 0 || x > row - 1 || y < 0 || y > col - 1 || image[x][y] != target)
                        continue;
                    image[x][y] = color;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return image;
    }
}