import java.util.*;

class Solution217 {
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }

        return false;
    }
}

public class LeetCode217_ver2 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,5};
        Solution217 solution = new Solution217();
        boolean result = solution.containsDuplicate(nums);
        System.out.println(result);
    }
}
