/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dict=new int[26];
        // dict={0};

        int n=s.length();
        int m=t.length();

        if (m!=n){
            return false;
        }
        
        for (int i =0;i<n;i++){
            int idx=s.charAt(i)-'a';
            dict[idx]++;
        }
        for(int i=0;i<m;i++){

            int idx=t.charAt(i)-'a';

            dict[idx]--;
            
            if (dict[idx]<0){
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

