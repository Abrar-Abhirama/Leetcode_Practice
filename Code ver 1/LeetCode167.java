import java.util.*;

class TwoSumSolution{
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int temp;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            temp = target - numbers[i] ;
            // System.out.println(temp);
            if (map.containsKey(temp)){
                result[1] = i + 1;
                result[0] = map.get(temp);
                result[0] ++;
                return result;
            }
            else{
                map.put(numbers[i], i);
            }
        } 
        return result;   
    }
}

public class LeetCode167 {
    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int[] numbers = {2,7,11,15};
        int[] result = solution.twoSum(numbers, 9);
        System.out.println(Arrays.toString(result));
    }
}
