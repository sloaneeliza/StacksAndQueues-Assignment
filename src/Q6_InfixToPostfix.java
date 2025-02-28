import java.util.*;

public class Q6_InfixToPostfix {
    private static final Map<Character, Integer> precedenceMap = new HashMap<>();

    static {
        precedenceMap.put('^', 3);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
    }

    public static String infixToPostfix(String expression) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    private static int precedence(char op) {
        return precedenceMap.getOrDefault(op, -1);
    }
    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(infixExpression));
    }
}
