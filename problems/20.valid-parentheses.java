
/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int length=s.length();
        char[] stack=new char[length];
        int last=-1;

        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if (c=='('||c=='{'||c=='['){
                stack[++last]=c;
            }
            else{
                if (last==-1){
                    return false;
                }
                if ((c==')'&&stack[last]=='(')||(c==']'&&stack[last]=='[')||(c=='}'&&stack[last]=='{')){
                    last--;
                }
                else{
                    return false;
                }
            }

        }

        if(last==-1){
            return true;
        }
        return false;
    }
}
// @lc code=end

