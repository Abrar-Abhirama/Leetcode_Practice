import java.util.*;
import java.lang.String;

class PalindromSolution{
    public boolean isPalindrome(String s) {
        boolean result = true;
        String obj = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] var = obj.toCharArray();
        char[] var2 = new char[var.length];
        int max = var.length;
        for (int i = 0; i < max ; i++){
            var2[max - i -1] = var[i];
        }

        if (!Arrays.equals(var, var2)){
            // System.out.println('d');
            result = false;
        }

        // System.err.println(Arrays.toString(var));
        // System.err.println(Arrays.toString(var2));

        return result; 
    }
}

public class LeetCode125 {
    public static void main(String[] args){
        PalindromSolution solution = new PalindromSolution();
        String s = "A man, a plan, a canal: Panama";
        boolean result = solution.isPalindrome(s);
        System.err.println(result);
    }
}
