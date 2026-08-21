import java.util.*;

class LongestSubstringSolution{
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0, right, total =0;
        HashSet<Character> set = new HashSet<>();
        for (int i  = 0; i < s.length(); i++){
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(i));
            result = Math.max(result, (i-left + 1));
            
        }

        return result;
    }
}

public class LeetCode3 {
    public static void main(String[] args){
        LongestSubstringSolution solution = new LongestSubstringSolution();
        String s = "1R1T7";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
