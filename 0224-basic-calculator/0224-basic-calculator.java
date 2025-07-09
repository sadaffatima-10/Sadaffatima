class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int number = 0;
        int result = 0;
        int sign = 1;

        for(char c : s.toCharArray()){
            if( Character.isDigit(c) ){
                //number banao
                number = (number * 10) + c-'0';
            }
            else if(c == '+'){
                result += number * sign;
                number = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += number * sign;
                number = 0;
                sign = -1;
            }
            else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c == ')'){
                result += number*sign; //bracket ke andar ka result
                number = 0;

                int stack_sign = stack.pop();
                int last_result = stack.pop();

                result *= stack_sign;
                result += last_result; 
            }
        }
        result += (number * sign);
        return result;
    }
}