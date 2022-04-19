import java.util.*;
public class main{
 public static void main(String[] args) {
    System.out.println("test");
    int[] nums={4,1,-1,2,-1,2,3};
    int k=2;
    int[] res=new int[k];
    
    res=topKFrequent(nums,k);
    for (int i :res){
        System.out.println(i);
    }
    
    }


public static int[] topKFrequent(int[] nums, int k) {
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
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for(int key:map.keySet()){

            int freq=map.get(key);
            System.out.println("key:"+key+" ,freq:"+freq);
            System.out.println(heap);
            if (heap.size()<k ){
                // 如果heap size<k 或者 当前freq大于堆顶
                heap.add(key);
            }
            else if(freq>=map.get(heap.peek())){
                System.out.print("top"+heap.peek());
                System.out.print("map"+map.get(heap.peek()));
                heap.remove();
                heap.add(key);
            }

            // if (heap.size()<k || freq>=map.get(heap.peek())){
            //     // 如果heap size<k 或者 当前freq大于堆顶
            //     heap.add(key);
            // }
            // else if(freq>map.get(heap.peek())){
            //     heap.remove();
            //     heap.add(key);
            // }
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