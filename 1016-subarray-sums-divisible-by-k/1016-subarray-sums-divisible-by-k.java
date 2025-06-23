class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> remFreq = new HashMap<>();

        remFreq.put(0,1);
        int count = 0;
        int runningSum = 0;

        for(int num : nums){
            runningSum += num;
            int remainder = runningSum % k;

            if (remainder < 0) {
                remainder += k;
            }
            
            if(remFreq.containsKey(remainder)){
                count += remFreq.getOrDefault(remainder,0);
            }
            remFreq.put(remainder, remFreq.getOrDefault(remainder,0) + 1 );
        }
        return count;
    }
}