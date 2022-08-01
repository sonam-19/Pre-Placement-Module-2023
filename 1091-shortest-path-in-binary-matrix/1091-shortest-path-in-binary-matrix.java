class Solution {
   public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }

        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] DIRS = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        queue.offer(new int[]{0, 0});
        int step = 1;
        int[] curr = {0, 0};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                if (curr[0] == n - 1 && curr[1] == n - 1) {
                    return step;
                }

                for (int[] dir : DIRS) {
                    int nextR = curr[0] + dir[0], nextC = curr[1] + dir[1];
                    if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || grid[nextR][nextC] != 0) {
                        continue;
                    }
                    queue.offer(new int[]{nextR, nextC});
                    grid[nextR][nextC] = 2;
                }
            }
            step++;
        }
        return -1;
    }
}