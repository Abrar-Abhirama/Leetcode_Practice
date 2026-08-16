import java.util.*;

class LeetCode1Solution{
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i= 0; i < nums.length; i++){
            int temp = nums[i];
            for (int j = i + 1 ; j < nums.length; j++){
                if (temp + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
    return result;
    }
}

public class LeetCode1 {
    public static void main(String[] args){
        LeetCode1Solution solution = new LeetCode1Solution();
        int [] nums = {2,7,11,15};
        int target = 26;
        int [] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
