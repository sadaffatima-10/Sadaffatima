class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if (ch == '(') {
                if (!stack.isEmpty()) {
                    result.append(ch); // Only add if it's not the outermost
                }
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(ch); // Only add if it's not the outermost
                }
            }
        }
        return result.toString();
    }
}
