import java.util.*;

class LargestRectangleSolution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, width = 0;
        for (int i = 0; i < heights.length; i++){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int height = heights[stack.pop()];
                if (stack.isEmpty()) {
                    width = i;
                }
                else{
                    width = i - stack.peek() - 1;
                }
                
                int area = height * width;
                result = Math.max(result, area);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
                if (stack.isEmpty()) {
                    width = heights.length;
                }
                else{
                    width = heights.length - stack.peek() - 1;
                }
                
                int area = height * width;
                result = Math.max(result, area);
            
        }
        return result;
    }
}

public class LeetCode84 {
    
    public static void main(String[] args){
        LargestRectangleSolution solution = new LargestRectangleSolution();
        int[] heights =  {2,1,5,6,2,3};
        int result = solution.largestRectangleArea(heights);
        System.out.println(result);
    }
    
}
