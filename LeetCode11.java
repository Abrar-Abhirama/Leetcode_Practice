import java.security.KeyStore.Entry;
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

class ContainerOptimalSolution{
    public int maxArea(int[] height){
        int result = 0;
        int left = 0;
        int right = height.length -1;

        while (left < right){
            int lowest = Math.min(height[left], height[right]);
            int total = (right-left) * lowest;

            result = Math.max(total, result);
            if (height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return result;
    }
}


public class LeetCode11 {
    public static void main(String[] args){
        ContainerOptimalSolution solution = new ContainerOptimalSolution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(height);
        System.out.println(result);
    }
}
