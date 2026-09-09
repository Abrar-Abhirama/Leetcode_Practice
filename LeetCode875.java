import java.util.Arrays;

class KokoEatingBananasSolution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = piles[0];
        for (int i = 0; i < piles.length ; i++){
            if (piles[i] > max){
                max = piles[i];
            }
        }
        
        int[] arr = new int[max];
        for (int i = 0; i < max ; i++){
            arr[i] = i + 1;
        }
    //    System.out.println(Arrays.toString(arr));
        int left = 0, right = max -1, result = 9999;
        while (left <= right){
            int mid = left + (right-left) /2;
            // System.out.println(arr[mid]);
            int totaltemp = 0;
            for (int i = 0; i < piles.length ;i++){
                // System.out.println(piles[i]);
                // System.out.println(arr[mid]);
                int temp = (int) Math.ceil((double) piles[i] / arr[mid]) ;
                // System.out.println(temp);
                totaltemp += temp;
            }

            if (totaltemp == h){
                return mid + 1;
            }
            if (totaltemp < h){
                right = mid -1;
            }
            else if (totaltemp > h){
                left = mid + 1;
            }

            totaltemp = 0;

            
            // System.out.println(totaltemp);
         
            
        }
    
        return 0;
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