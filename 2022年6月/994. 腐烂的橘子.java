class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] direction = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }
        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] position = queue.poll();
                for(int[] dir : direction) {
                    int x = position[0] + dir[0];
                    int y = position[1] + dir[1];
                    if(x < 0 || x > row - 1 || y < 0 || y > col - 1 || grid[x][y] != 1)
                        continue;
                    queue.offer(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
            time++;
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return time == 0 ? 0 : time - 1;
    }
}
