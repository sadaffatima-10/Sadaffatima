class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String ch : operations){
            if(ch.equals("+")){
                int last = stack.pop();
                int secondLast = stack.peek();
                int sum = last + secondLast;
                stack.push(last);
                stack.push(sum);
            }
            else if(ch.equals("D")){
                stack.push( 2 * stack.peek());
            }
            else if(ch.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(ch)); 
            }
        }
        int total = 0;
        for(int i : stack){
            total += i;
        }
        return total;
    }
}