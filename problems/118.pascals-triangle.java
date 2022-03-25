/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new LinkedList<>();

        if (numRows==0){            
            return res;
        }

        if (numRows>=1){
            List<Integer> layer = new ArrayList<>();
            layer.add(1);
            res.add(layer);
            
        }
        if(numRows>=2){
            List<Integer> layer = new ArrayList<>();
            layer.add(1);
            layer.add(1);
            res.add(layer);
        }
        
        // numRows>=3
        if(numRows>=3){

    
            for (int i=3;i<=numRows;i++){
                List<Integer> prev = res.get(i-2);
                List<Integer> cur=new ArrayList<>();
                cur.add(1);
                for (int j=1;j<i-1;j++){
                    cur.add(prev.get(j-1)+prev.get(j));
                }
                cur.add(1);
    
                res.add(cur);
            }
    
            
    
        }
        //第一层
       return res;
    }
}
// @lc code=end

