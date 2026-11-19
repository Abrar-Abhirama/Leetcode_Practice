import java.util.*;

class Search2DSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left, right, row = -1;
        
        for (int i = 0; i < matrix.length ;i++){
            left = 0;
            right = matrix[i].length -1 ;
            if (target >= matrix[i][left] && target <= matrix[i][right]){
                row = i;
                break;
            }
        }
        left = 0;
        right = matrix[row].length - 1;
        while (left <= right){
            int mid = left + (right - left) /2;

            if (matrix[row][mid] == target){
                return true;
            }
            else if (matrix[row][mid] < target){
                left = mid +1;
            }
            else if (matrix[row][mid] > target){
                right = mid -1;
            }
        }

        // System.out.println(row);
        return false;
        
    }
}

class OptimalSearch2DSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        // Find the correct row
        while (top <= bottom) {
            int row = top + (bottom - top) / 2;

            if (target >= matrix[row][0] &&
                target <= matrix[row][matrix[row].length - 1]) {

                // Binary search inside the row
                int left = 0;
                int right = matrix[row].length - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (matrix[row][mid] == target) {
                        return true;
                    } else if (matrix[row][mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                return false;
            }

            if (target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                top = row + 1;
            }
        }

        return false;
    }
}

public class LeetCode74 {
    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        Search2DSolution solution = new Search2DSolution();
        boolean result = solution.searchMatrix(matrix, 12);
        System.out.println(result);
    }
}
