class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int remainder = target -nums[i];
            if(map.containsKey(remainder)){
                list.add(map.get(remainder));
                list.add(i);
            }else{
                map.put(nums[i], i);
            }
        }
        int[] result= new int[list.size()];
        for(int i=0; i< list.size(); i++){
            result[i]= list.get(i);
        }
        return result;
    }
}