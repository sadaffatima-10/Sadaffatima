class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Remove all elements greater than current price
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // If stack is not empty, top is the discount
            result[i] = prices[i] - (stack.isEmpty() ? 0 : stack.peek());

            // Push current price for future elements
            stack.push(prices[i]);
        }

        return result;
    }
}
