import java.util.*;

class RPNSolution{
    public int evalRPN(String[] tokens) {
        Stack<Integer>  stack = new Stack<>();
        int length = tokens.length;
        for (int i = 0 ; i < length ;i++){
            // System.out.println(tokens[i]);
            if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "/" && tokens[i] != "*"){
                // System.out.println(tokens[i]);
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                int temp = 0;
                if (tokens[i] == "+") temp = val2 + val1;
                if (tokens[i] == "-") temp = val2 - val1;
                if (tokens[i] == "/") temp = val2 / val1;
                if (tokens[i] == "*") temp = val2 * val1;
                stack.push(temp);
                // System.out.println(stack);
            }
        }
        // System.out.println(stack);
        return stack.peek();

    }
}


public class LeetCode150 {
    public static void main(String[] args) {
        RPNSolution solution = new RPNSolution();
        String[] tokens ={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        String[] tokens2 = {"2","1","+","3","*"};
        int result = solution.evalRPN(tokens2);
        System.out.println(result);
    }

}
