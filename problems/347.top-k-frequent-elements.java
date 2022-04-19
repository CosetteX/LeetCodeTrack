import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
// 桶排序：空间O(n), 时间O(n)
// import java.util.*;
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // 类似largest K element
//         // 维护一个大小为k的最大堆直至输入结束
//         // -- 也可以使用桶排序
//         // 区别：需要先创建一个hashmap，根据数字的frequency排序
//         int[] res = new int[k];
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for (int num:nums){
//             if(map.containsKey(num)){
//                 map.put(num, map.get(num) + 1);
//             }else{
//                 map.put(num,1);
//             }
//         }
        
//         List<Integer>[] list=new List[nums.length+1];

//         for(int key:map.keySet()){
//             int freq=map.get(key);
//             if(list[freq]==null){
//                 list[freq]=new ArrayList<>();
//             }
//             list[freq].add(key);
//         }
        
//         int idx=0;
        
//         for(int i = list.length - 1;i >= 0&&idx<k ;i--){
//             if(list[i] == null) continue;
//             for(int element:list[i]){
//                 res[idx]=element;
//                 idx++;
//             }
//         }
        
//         return res;

//     }
// }


// 最小堆
import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 类似largest K element
        // 维护一个大小为k的最大堆直至输入结束
        // -- 也可以使用桶排序
        // 区别：需要先创建一个hashmap，根据数字的frequency排序
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num:nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }

        PriorityQueue heap=new PriorityQueue<>(new Comparator<Integer>() {
            // 为了保证heap能正常更新，要重写这个comparator
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for(int key:map.keySet()){

            int freq=map.get(key);

            if (heap.size()<k ){
                // 如果heap size<k 或者 当前freq大于堆顶
                heap.add(key);
            }
            else if(freq>=map.get(heap.peek())){

                heap.remove();
                heap.add(key);
            }


        }
        int idx=0;
        int[] res=new int [k];
        
        while (!heap.isEmpty()) {
            res[idx]=(int) heap.remove();
            idx++;
            // res.add(heap.remove());
        }
        return res;
        

    }
}
// @lc code=end

