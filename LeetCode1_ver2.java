import java.util.*;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int n = target - nums[i];
            if (map.containsKey(n)){
                return new int[]{map.get(n), i};
            }
            else{
                map.put(nums[i], i);
            }
        }
        
        return null;
    }
}

public class LeetCode1_ver2 {
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution1 solution = new Solution1();
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }
}
