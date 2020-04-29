package No63_UniquePathsⅡ;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        /* base case */
        if (obstacleGrid[0][0] == 1)
            return 0;
        obstacleGrid[0][0] = 1;
        for (int j = 1; j < C; j ++) {
            //前面一个没有障碍 当前这个也没有障碍 只有这一种情况才可以满足当前是无障碍的 如果想在if中判断有障碍 会非常复杂
            if (obstacleGrid[0][j - 1] == 1 && obstacleGrid[0][j] == 0) {
                obstacleGrid[0][j] = 1;
            } else {
                obstacleGrid[0][j] = 0;
            }
        }

        for (int i = 1; i < R; i ++ ) {
            if (obstacleGrid[i - 1][0] == 1 && obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            }else {
                obstacleGrid[i][0] = 0;
            }
        }

        /* dp */
        for (int i = 1; i < R; i ++) {
            for (int j = 1; j < C; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }
}
