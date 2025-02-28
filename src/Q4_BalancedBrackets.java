import java.util.Deque;
import java.util.LinkedList;

public class Q4_BalancedBrackets {
    public static String isBalanced(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.addLast(ch);
            }
            else {
                if (stack.isEmpty()) return "NO";

                char top = stack.removeLast();
                if ((ch == '}' && top != '{') ||
                        (ch == ')' && top != '(') ||
                        (ch == ']' && top != '[')) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        String[] testCases = {"{[()]}", "{[(])}", "{{[[(())]]}}"};

        for (String test : testCases) {
            System.out.println(isBalanced(test));
        }
    }
}
