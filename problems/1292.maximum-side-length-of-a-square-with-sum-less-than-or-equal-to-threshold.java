/*
 * @lc app=leetcode id=1292 lang=java
 *
 * [1292] Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 */

// @lc code=start
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int a = mat.length;
        int b = mat[0].length;
        int[][] arr = new int[a + 1][b + 1];
        int min = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                arr[i][j] = mat[i - 1][j - 1] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
                int st = 0;
                int end = Math.min(i, j);
                while (st <= end) {
                    int m = st + ((end - st) >> 1);
                    int sum = arr[i][j] + arr[i - m][j - m] - arr[i - m][j] - arr[i][j - m];
                    if (sum <= threshold) {
                        st = m + 1;
                        min = Math.max(m, min);
                    } else {
                        end = m - 1;
                    }
                }
            }
        }
        return min;
    }
}
// @lc code=end

