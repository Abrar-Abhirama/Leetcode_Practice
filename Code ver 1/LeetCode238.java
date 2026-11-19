import java.util.*;

class ArrayExceptSolution{
    public int[] productExceptSelf(int[] nums) {
        Integer total = 1;
        Integer flag0 = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length ; i ++){
            if (nums[i] != 0){
                total = total * nums[i];
            }
            else{
                flag0 += 1;
            }
            // System.out.println(total);
        } 

        if (flag0 > 1){
            for (int i = 0; i < nums.length;i++){
                result[i] = 0;
            }
            return result;
        }
        System.out.println(total);
        Integer temp = 1;
        for (int i = 0; i < nums.length ;i++){
            if (nums[i] == 0){
                temp = total;
            }
            else{
                if (flag0 == 1){
                    temp = 0;
                }
                else{
                    temp = total / nums[i];
                }
            }   
            result[i] = temp;
            temp = total;
            // System.out.println(result[i]);
        }
        
        // System.out.println(Arrays.toString(result));
        return result;
    }
}

public class LeetCode238{
    public static void main(String[] args){
        ArrayExceptSolution solution = new ArrayExceptSolution();
        int[] nums = {1,2,3,4};
        int[] result = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}