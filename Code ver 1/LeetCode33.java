class SearchInRotatedSolution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[left] <= nums[mid]){
                if (target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }   
            }
            else{
                if (target <= nums[right] && target >= nums[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}

public class LeetCode33 {
    public static void main(String[] args) {
        SearchInRotatedSolution solution = new SearchInRotatedSolution();
        int[] nums = {5,1,2,3,4};
        int target = 1;
        int result = solution.search(nums, target);
        System.out.println(result);
    }    
}
