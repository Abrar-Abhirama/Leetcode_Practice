import java.util.Arrays;

class KokoEatingBananasSolution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 0; i < piles.length ; i++){
            if (piles[i] > max){
                max = piles[i];
            }
        }
        
        int left = 1, right = max, result = right;
        while (left <= right){
            int mid = left + (right-left) /2;
            // System.out.println(arr[mid]);
            long totaltemp = 0;
            for (int i = 0; i < piles.length ;i++){
                // System.out.println(piles[i]);
                // System.out.println(arr[mid]);
                long temp = (long) Math.ceil((double) piles[i] / mid) ;
                // System.out.println(temp);
                totaltemp += temp;
            }

            if (totaltemp <= h){
                result = mid;
                right = mid -1;
            }
            else if (totaltemp > h){
                left = mid + 1;
            }   
            // System.out.println(totaltemp);

        }
    
        return result;
    }
}


public class LeetCode875 {
    public static void main(String[] args){
        KokoEatingBananasSolution solution = new KokoEatingBananasSolution();
        int[] piles = {30,11,23,4,20};
        int h = 5; 
        int result = solution.minEatingSpeed(piles, h);
        System.out.println(result);
    }
}