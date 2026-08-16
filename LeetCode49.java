import java.util.*;

class GroupAnagramSolution{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        char[] temp;
        for (int i = 0; i < strs.length; i++){
            temp = strs[i].toCharArray();
            String value = new String(temp);
            Arrays.sort(temp);
            String key = new String(temp);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
                map.get(key).add(value);
            }
            else{
                map.get(key).add(value);
            }
        }

        for (String key : map.keySet()){
            result.add(map.get(key));
        }

        // System.out.println(map);
        // System.out.println(result);
        return result;
    }
}

public class LeetCode49 {
    public static void main(String[] args){
        GroupAnagramSolution solution = new GroupAnagramSolution();
        String[] nums = {"awo", "awa", "awwwwwaaaa","owa","waa","wao"};
        List<List<String>> result = new ArrayList<>();
        result = solution.groupAnagrams(nums);
    }
}
