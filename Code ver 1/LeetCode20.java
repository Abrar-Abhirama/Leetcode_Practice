import java.util.*;

class ValidParenthesesSolution{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '['){
                stack.push(curr);
            }
            else{
                if (stack.empty()) return false;
                if (curr == ')' && stack.peek() != '('){
                    // System.out.println("Masuk 1");
                    return false;
                }

                else if (curr == '}' && stack.peek() != '{'){
                    // System.out.println("Masuk 2");
                    return false;
                }
                else if (curr == ']' && stack.peek() != '['){
                    // System.out.println("Masuk 3");
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        
        if (stack.size() != 0){
            return false;
        }
        return true;
    }
}

public class LeetCode20 {
    public static void main(String[] args) {
        ValidParenthesesSolution solution = new ValidParenthesesSolution();
        String s = ")";
        boolean result = solution.isValid(s);
        System.out.println(result);
    }
}
