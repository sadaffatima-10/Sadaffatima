class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        

        int[] result = new int[nums1.length];
        for(int i=0; i< nums1.length; i++){
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}