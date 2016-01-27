package datastructure.stack;
import java.util.Stack;
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        String operator = "+-*/";
        for (String token : tokens) {
            if (operator.contains(token)) {
                int y = stack.pop();
                int x = stack.pop();
                if (token.equals("+")) {
                    stack.push(x + y);
                } else if (token.equals("-")) {
                    stack.push(x - y);
                } else if (token.equals("*")) {
                    stack.push(x * y);
                } else {
                    stack.push(x / y);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
	public static void main(String[] args) {
		String[] number = {"4", "3", "*"};
		EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
		int result = solution.evalRPN(number);
		System.out.println(result);
	}
}
