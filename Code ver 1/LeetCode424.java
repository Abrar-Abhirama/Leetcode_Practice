import java.util.*;

class LongestRepeatSolution{
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        s = s.toUpperCase();
        int left = 0, result = 0, maxFreq = 0;
        for (int right = 0; right < s.length(); right++){
            char current = s.charAt(right);

            map.put(current, map.getOrDefault(current, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(current));

            int windowSize = right - left + 1;
            int replace = windowSize - maxFreq;

            if (replace > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
            
        }

        return result;
    }
}

public class LeetCode424 {
    public static void main(String[] args){
        LongestRepeatSolution solution = new LongestRepeatSolution();
        String s = "aababba";
        int k = 2;
        int result = solution.characterReplacement(s, k);
        System.out.println(result);
    }
}

// aaba b

