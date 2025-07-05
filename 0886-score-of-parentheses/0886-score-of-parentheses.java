class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(0);
            }
            else{
                int val = 0;
                while(stack.peek() != 0){
                    val += stack.pop();
                }
                stack.pop();
                if(val == 0){
                    stack.push(1);
                }
                else{
                    stack.push(2 * val);
                }
            }
        }
        int score = 0;
        while(!stack.isEmpty()){
            score += stack.pop();
        }

        return score;
    }
}