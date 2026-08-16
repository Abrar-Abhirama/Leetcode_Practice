import java.util.*;

class TopKSolution{
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i< nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet() ){
            queue.offer(entry);

            if(queue.size() > k){
                queue.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k;i++){
            result[i] = queue.poll().getKey();
            // System.out.println(i);
        }


        
        // System.out.println(map);
        // System.out.println(queue);
        return result;
    }
}


public class LeetCode347 {
    public static void main(String[] args){
        int[] nums = {1,2,2,3,4,5,5};
        int k = 2;
        TopKSolution solution = new TopKSolution();
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
