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

class Sum3OptimalSolution{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>() {};
        Arrays.sort(nums);
        int left, right, total;
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            left = i + 1;
            right = nums.length-1;

            while (left < right){
                total = nums[i] + nums[left] + nums[right];
                if (total == 0){
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left -1]){
                        left++;
                    }
                    while (left< right && nums[right] == nums[right + 1]){
                        right --;
                    }

                }

                else if (total  < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }


        return result;
    }
}

public class LeetCode15 {
    public static void main(String[] args){
        Sum3OptimalSolution solution = new Sum3OptimalSolution();
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }
}
