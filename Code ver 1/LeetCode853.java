import java.util.*;

class CarFleetSolution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < position.length; i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(b[0], a[0]));
        // System.out.println(Arrays.deepToString(arr));

        for (int i = 0; i < arr.length; i++){
            double time = (double)(target - arr[i][0]) / arr[i][1];
            // System.out.println(time);
            if (stack.isEmpty() || time > stack.peek()) stack.push(time);
        }

        // System.out.println(stack);
        return stack.size();
    }
}

public class LeetCode853 {

    public static void main(String[] args){
        CarFleetSolution solution = new CarFleetSolution();
        int target = 10;
        int[] position = {8,3,7,4,6,5} ;
        int[] speed = {4,4,4,4,4,4};
        int result = solution.carFleet(target, position, speed);
        System.out.println(result);
    }
    
    

}
