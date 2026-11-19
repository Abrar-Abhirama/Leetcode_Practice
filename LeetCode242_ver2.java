import java.util.*;

class Solution242 {
    public boolean isAnagram(String s, String t){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : s.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0) +1);
        }

        for (char c : t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        if (map1.equals(map2)){
            return true;
        }
        
        return false;    
    }
}

public class LeetCode242_ver2 {
    public static void main(String[] args){
        Solution242 solution = new Solution242();
        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);
        System.out.println(result);
    }
}
