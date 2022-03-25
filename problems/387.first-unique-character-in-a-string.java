/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        
        Map<Character,Integer> hashtable=new LinkedHashMap<Character,Integer>();
        // 用LinkedHashMap保证插入顺序

        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if (hashtable.containsKey(ch)==true){
                hashtable.remove(ch);
                hashtable.put(ch,-1);
            }
            else{
                hashtable.put(ch,i);
            }
        }


        Iterator iter = hashtable.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry)iter.next();
            if (entry.getValue() == -1) {
                continue;
            }
            return entry.getValue();
        }
        return -1;
    }
}
// @lc code=end

