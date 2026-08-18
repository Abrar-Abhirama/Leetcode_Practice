import java.util.*;

class ContainerSolution{
    public int maxArea(int[] height){
        int result = 0;
        int currTotal, lowest; 
        for (int i = 0; i < height.length;i++){
            for (int j = i + 1; j < height.length; j++){
                lowest = Math.min(height[i], height[j]);
                currTotal = (j-i) * lowest;
                if (currTotal > result){
                    result = currTotal;
                }
            }
        }
        return result;
    }
}


public class LeetCode11 {
    public static void main(String[] args){
        ContainerSolution solution = new ContainerSolution();
        int[] height = {1,1};
        int result = solution.maxArea(height);
        System.out.println(result);
    }
}
