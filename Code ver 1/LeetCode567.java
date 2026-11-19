import java.util.*;

class PermutationSolution{
    public boolean checkInclusion(String s1, String s2) {
        boolean result = false;
        int left = 0, length = s1.length(), lengths2 = s2.length();
        if (length > lengths2) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i<s1.length() ; i++){
            char curr = s1.charAt(i);
            char curr2 = s2.charAt(i);
            map1.put(curr, map1.getOrDefault(curr, 0) + 1);
            map2.put(curr2, map2.getOrDefault(curr2, 0) + 1);
        }
        // System.out.println(map1);
        // System.out.println(map2);
        for (int right = (length -1) ; right < s2.length() ; right++){            
            if (right == length -1){
                if(map1.equals(map2)) return true;
                else {
                    map2.put(s2.charAt(left), map2.get(s2.charAt(left)) - 1);
                    if (map2.get(s2.charAt(left)) == 0){
                        map2.remove(s2.charAt(left));
                    }
                    left++;
                }
            }
            
            else{
                map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right), 0) + 1);
                // System.out.println("map 2: " + map2);
                if (map1.equals(map2)){
                    return true;
                }
                map2.put(s2.charAt(left), map2.get(s2.charAt(left)) - 1);
                if (map2.get(s2.charAt(left)) == 0){
                    map2.remove(s2.charAt(left));
                }
                // System.out.println("map 2 setelah delete: " + map2);
                left ++;
            }
        }
        return result;
    }
}

public class LeetCode567 {
    public static void main(String[] args){
        PermutationSolution solution = new PermutationSolution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = solution.checkInclusion(s1, s2);
        System.out.println(result);
    }
}
