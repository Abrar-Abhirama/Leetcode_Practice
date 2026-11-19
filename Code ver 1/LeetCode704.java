class BinarySolution{
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = 0;

         if (nums.length == 1 && nums[0] == target){
            return 0;
        }

        while (left < right){
            mid = left + (right - left) / 2;
            System.out.println(mid);
            System.out.println(nums[mid]);
            if (nums[mid] < target){
                left = mid + 1;
            }
            else if (nums[mid] > target){
                right = mid - 1;
                if (right < 0) right = 0;
            }
            
            if (nums[mid] == target ){
                return mid;
            }
            else if (nums[left] == target){
                return left;
            }
            else if(nums[right] == target){
                return right;
            }
        }

        return -1;
        
    }
}

class OptimalBinarySolution{
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }
            else if (nums[mid] > target){
                right = mid - 1;
            }
            
            if (nums[mid] == target ){
                return mid;
            }
        }

        return -1;
        
    }
}


public class LeetCode704 {
    public static void main(String[] args){
        OptimalBinarySolution solution = new OptimalBinarySolution();
        int[] nums = {2,5};
        int result = solution.search(nums, 0);
        System.out.println(result);
    }
}
