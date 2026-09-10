class FindMinSolution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;

        while (left <right){
         int mid = left + (right - left) / 2;

         if (nums[mid] > nums[right]){
            left = mid + 1;
         }
         else{
            right = mid;
         }
        }
        return nums[left];        
    }    
}

public class LeetCode153 {
    public static void main(String[] args){
        FindMinSolution solution = new FindMinSolution();
        int[] nums = {3,4,5,1,2};
        int result = solution.findMin(nums);
        System.out.println(result);
    }
}
