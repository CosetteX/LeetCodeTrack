/*
 * @lc app=leetcode id=566 lang=java
 *
 * [566] Reshape the Matrix
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        if (m*n!=r*c){
            return mat;
        }
        
        int[][] ans=new int[r][c];
        int row=0;
        int col=0;
        for(int[] i : mat){
           
            for(int j :i){
                ans[row][col%c]=j;
                col++;    
                if (col%c==0 && col>0){
                    row++;
                }  
                         
            }
            


        }
        return ans;
    }
}
// @lc code=end

