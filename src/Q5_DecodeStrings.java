import java.util.Stack;

public class Q5_DecodeStrings {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                int repeatCount = countStack.pop();
                StringBuilder decodedPart = stringStack.pop();

                for (int i = 0; i < repeatCount; i++) {
                    decodedPart.append(currentString);
                }
                currentString = decodedPart;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]")); //"aaabcbc"
        System.out.println(decodeString("3[a2[c]]"));  //"accaccacc"
        System.out.println(decodeString("2[abc]3[cd]ef")); //"abcabccdcdcdef"
    }
}
