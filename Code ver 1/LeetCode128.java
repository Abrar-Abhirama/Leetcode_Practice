import java.util.*;

import javax.print.attribute.HashAttributeSet;

class LongestConsecutiveSolution{
     public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int result = 0;
        int streak = 0;
        int number;
        for (int check : set){
            if (!set.contains(check -1)){
                streak = 1;
                number= check;
                while(set.contains(number + 1)){
                    streak ++;
                    number ++;
                }
            }
            result = Math.max(streak, result);
        }
        
        
        // System.out.println(set);
        return result;
    }
}


public class LeetCode128 {
    public static void main(String[] args){
        LongestConsecutiveSolution solution = new LongestConsecutiveSolution();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }
}
