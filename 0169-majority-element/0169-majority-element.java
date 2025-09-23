class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int element = 0;

        for(int num : nums){
            if(map.containsKey(num)){
                int freq = map.get(num);
                map.put(num, freq+1);
            }
            else{
                map.put(num,1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key) > n/2){
                element = key;
            }
        }
        return element;
    }
}