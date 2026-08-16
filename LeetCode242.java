import java.util.*;

class AnagramSolution {
    public boolean isAnagram(String s, String t){
        Map<String, Integer> mapS = new HashMap<>();
        Map<String, Integer> mapT = new HashMap<>();
        int lengthS = s.length();
        int lengthT = t.length();

        if (lengthS != lengthT){
            return false;
        }

        for (int i = 0; i < lengthS ; i++){
            if (!mapS.containsKey(String.valueOf(s.charAt(i)))){
                mapS.put(String.valueOf(s.charAt(i)),1);
            }
            else{
                mapS.put(String.valueOf(s.charAt(i)), mapS.get(String.valueOf(s.charAt(i))) + 1 );
            }
        }

        for (int i = 0; i < lengthS ; i++){
            if (!mapT.containsKey(String.valueOf(t.charAt(i)))){
                mapT.put(String.valueOf(t.charAt(i)),1);
            }
            else{
                mapT.put(String.valueOf(t.charAt(i)), mapT.get(String.valueOf(t.charAt(i))) + 1 );
            }
        }

        // System.out.println(mapS);
        // System.out.println(mapT);

        return mapS.equals(mapT);
    }
}


public class LeetCode242 {
    public static void main(String[] args){
        AnagramSolution solution = new AnagramSolution();
        String s = "awoaaawi";
        String t = "owaaaawi";
        boolean result = solution.isAnagram(s, t);
        System.out.println(result);
    }
}
