class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        int sum = 0;
        int count = 0;

        for(int num : nums){
            sum += num;

            if(prefixSum.containsKey(sum-k)){
                int freq = prefixSum.get(sum-k);
                count += freq;
            }
            /*if((sum-k) == 0){
                count++;
            }*/

            prefixSum.put(sum, prefixSum.getOrDefault(sum,0)+1); 
        }
        return count;
    }
}