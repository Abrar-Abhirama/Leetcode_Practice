import java.util.*;

class Sum3Solution{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>() {};
        Arrays.sort(nums);
        int curr, total;
        for (int i = 0; i < nums.length; i ++){
            curr = nums[i];
            // System.out.println(curr);
            for (int j = i + 1; j < nums.length ; j++){
                // System.out.println(nums[j]);
                for (int z = j + 1; z < nums.length; z++){
                    // System.out.println(total);
                    total = nums[i] + nums[j] + nums[z];
                    if (total == 0 && !result.contains(List.of(nums[i],nums[j],nums[z]))){
                        result.add(List.of(nums[i],nums[j],nums[z]));
                    }
                
                }
            }
        }

        return result;
    }
}

public class LeetCode15 {
    public static void main(String[] args){
        Sum3Solution solution = new Sum3Solution();
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }
}
