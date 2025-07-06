class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int length = stack.length();
            if (length > 0 && stack.charAt(length - 1) == c) {
                stack.deleteCharAt(length - 1); // Remove the last character
            } else {
                stack.append(c); // Add current character to the stack
            }
        }

        return stack.toString();
    }
}