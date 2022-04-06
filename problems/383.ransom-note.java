/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 借用python的count方法的思想
        // 用一个数组来count magazine里面字母出现的次数

        int[] cnt=new int[26];
        int n=magazine.length();

        for (int i=0;i<n;i++){
            int idx=magazine.charAt(i)-'a';
            cnt[idx]++;

        }

        int m=ransomNote.length();
        for (int i=0;i<m;i++){
            int idx=ransomNote.charAt(i)-'a';
            cnt[idx]--;

            if (cnt[idx]<0){

                return false;
            }
        }
        return true;
        
    }
}
// @lc code=end

