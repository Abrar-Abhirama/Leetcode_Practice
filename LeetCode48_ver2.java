import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            if (!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>(Arrays.asList(s)));
            }
            else{
                map.get(sorted).add(s);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> value : map.values()){
            result.add(value);
        }

        return result;
    }
}

public class LeetCode48_ver2 {
    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        Solution49 solution = new Solution49();
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    } 
}
