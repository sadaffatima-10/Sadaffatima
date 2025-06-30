class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(!stack.isEmpty()){
                    result.append(ch);
                }
                stack.push(ch);
            }
            else if(ch == ')'){
                stack.pop();
                if(!stack.isEmpty()){
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}