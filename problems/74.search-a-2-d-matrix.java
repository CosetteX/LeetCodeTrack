/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
            if(target>matrix[i][n-1]){
                continue;
            }
            else{
                for (int j=0;j<n;j++){
                    if (target==matrix[i][j]){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;

    }
}
// @lc code=end

