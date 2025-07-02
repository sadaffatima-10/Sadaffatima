import java.util.*;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -ast) {
                    stack.pop(); 
                } else if (top == -ast) {
                    stack.pop(); 
                    ast = 0;     
                    break;
                } else {
                    ast = 0;     
                    break;
                }
            }
            if (ast != 0) stack.push(ast); 
        }

        
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--)
            res[i] = stack.pop();
        return res;
    }
}
