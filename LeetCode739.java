import java.util.*;

class TemperatureSoluton{
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length]; 
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int pop= stack.pop();
                int temp = i - pop;
                arr[pop] = temp;

            }
            stack.push(i);
        }

        return arr;
    }

}

public class LeetCode739 {
    public static void main(String[] args){
        TemperatureSoluton solution = new TemperatureSoluton();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));        
    }
}

// 73 