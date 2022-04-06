/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l =1;
        int r=n;
        int mid;
        int res=-1;
       while(l<r){
           mid=l/2+r/2;
           if(guess(mid)==0){
               res=mid;
               break;
           }else if(guess(mid)==1){
               l=mid+1;
           }else if(guess(mid)==-1){
               r=mid;
           }

       }

       if (res==-1){
           if (guess(1)==0){
               res=1;
           }
           if(guess(n)==0){
               res=n;
           }
       }
       return res;

        
    }
}
// @lc code=end

