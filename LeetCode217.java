import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> temp = new HashSet<>();
        boolean result = false;
        for (int i = 0; i < nums.length - 1; i++){
            result = result || temp.contains(nums[i]) ? true :
            !temp.add(nums[i]);
        }
        result = result || temp.contains(nums[nums.length - 1]) ? true : !temp.add(nums[nums.length -1]);
        return result;
    }
}


public class LeetCode217{
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,2,3,4};
        boolean result = solution.containsDuplicate(nums);
        System.out.println(result);
    }
}