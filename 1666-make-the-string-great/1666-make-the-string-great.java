class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){

            if (!stack.isEmpty() && Character.toLowerCase(stack.peek()) == Character.toLowerCase(ch) && stack.peek() != ch) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }
} 