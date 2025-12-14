class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0;
        int length = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < n; i++){
            sum += nums[i];
            int remove = sum-goal;;
            length += map.getOrDefault(remove,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return length;
    }
}