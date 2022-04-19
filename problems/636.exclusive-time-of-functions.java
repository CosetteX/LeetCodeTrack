import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=636 lang=java
 *
 * [636] Exclusive Time of Functions
 */

// @lc code=start
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        //读取logs 将进程的开始时间入栈
        // 如果读取到的是进程的结束时间，弹出栈顶元素
        // 如果连续读取了相同的进程的开始时间，视作recursive call，要计算两个start之间的exclusive time
        // https://blog.csdn.net/huanghanqian/article/details/77160234

        int[] res=new int[n];
        Stack<Integer> stack =new Stack<>();
        String[] s = logs.get(0).split(":");
        
        stack.push(Integer.parseInt(s[0]));

        int i=1;
        int prev=Integer.parseInt(s[2]);
        // 上一个时间点
        while(i<logs.size()){
            s=logs.get(i).split(":");
            if (s[1].equals("start")){
                if (!stack.isEmpty()){
                    res[stack.peek()]+=Integer.parseInt(s[2])-prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev=Integer.parseInt(s[2]);
            }
            else{
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;//起点算，终点也算
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;//s[2]已经算作了该function的终点，不能再作为起点
            }
            i++;
        }
        return res;
    }
}
// @lc code=end

