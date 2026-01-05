class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i+1};
            }
            map.put(nums[i],i+1);
        }
        return new int[]{-1,-1};
    }
}