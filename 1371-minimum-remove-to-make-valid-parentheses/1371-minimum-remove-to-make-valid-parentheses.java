import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> invalidIndices = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();  
                } else {
                    invalidIndices.add(i);  //invalid set me ) ka index add kar liya
                }
            }
        }

        while (!stack.isEmpty()) {
            invalidIndices.add(stack.pop()); // second pass, bache hiye sare
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndices.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
