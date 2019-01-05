class Solution {

    private final int[] dirs = new int[]{0, -1, 0, 1, 0};
    
    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean isFound = false;
        
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m && !isFound; i++) {
            for (int j = 0; j < n && !isFound; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    isFound = true;
                }
            }
        }
        
        // BFS
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int dx = cur[0] + dirs[k];
                    int dy = cur[1] + dirs[k + 1];
                    if (dx < 0 || dx >= m || dy < 0 || dy >= n || A[dx][dy] == 2) continue;
                    if (A[dx][dy] == 1) return steps;
                    A[dx][dy] = 2;
                    queue.offer(new int[]{dx, dy});
                }
            }
            ++steps;
        }
        return -1;
    }
    
    private void dfs(int[][] A, int x, int y, Queue<int[]> queue) {
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] != 1) {
            return;
        }
        
        A[x][y] = 2;
        queue.offer(new int[]{x, y});
        
        for (int k = 0; k < 4; k++) {
            dfs(A, x + dirs[k], y + dirs[k + 1], queue);
        }
    }
    
}

