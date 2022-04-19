import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 仍然是单调栈问题
        // 用单调栈维护一组下标
        // 对栈中的每一个下标对应的元素，它的左边第一个比他小的元素的下标，就是栈中的前一个下标
        // 出栈时更新面积
        // test case [2,1,5,6,2,3]
        // 0(2)入栈==>{0(2)}
        // 读取1(1)，1<2, 0(2)出栈，1(1)入栈，res=2*1==>{1(1)}
        // 2(5)>1(1)入栈==>{1(1),2(5)}
        // 3(6)入栈==>{1(1),2(5),3(6)}
        // 4(2)<3(6),3(6)出栈，cnt+=1,res=6;==>{1(1),2(5)}
        // 4(2)<2(5),2(5)出栈，cnt+=1,res=5*cnt=10==>{1(1),4(2)}
        // ==>{1(1),4(2),5{3}}
        // 栈不为空，出栈并且记录面积

        // https://blog.csdn.net/Helene1996/article/details/123615415
        
        int len = heights.length;
        if (len == 0) {
           return 0;
       }

       if (len == 1) {
           return heights[0];
       }
       int[] newHeight = new int[len+2];
       //哨兵 避免栈空操作
       newHeight[0]=0;
       System.arraycopy(heights,0,newHeight,1,len);
       //哨兵，使得数组最后几个元素也可以被弹出，不需要特殊处理
       newHeight[len+1]=0;
       Stack<Integer> stack = new Stack<>();
       //提前将newHeight中第一个元素（哨兵）入栈，避免栈空无法进行stack.peek()操作
       stack.push(0);
       int area = 0;
       for(int i=1;i<len+2;i++){
           while(!stack.isEmpty()&&newHeight[i]<newHeight[stack.peek()]){
            //  当前height小于栈顶
            // 执行出栈操作，直至当前height>=栈顶
               int cur = stack.pop();
               //以cur所在矩形为最大高度的矩形，左边界是stack.peek()，右边界是i-1（因为i<栈顶，不能作为右边界）
               area=Math.max(area,newHeight[cur]*(i-1-stack.peek()));
           }
        //    当前height>==栈顶，入栈
           stack.push(i);
       }
       return area;
    }
}
// @lc code=end

