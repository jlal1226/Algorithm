package Programmers.StackQueue;

import java.util.Stack;

public class CorrectParentheses {
    public static void main(String[] args) {
        String s = "((((";
        boolean result = solution(s);
        System.out.println(result);
    }

    private static boolean solution(String s) {
        if (s.charAt(0) == ')') {
            return false;
        }

        Stack stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
