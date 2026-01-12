class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < n; i++){
            sum += nums[i];
            while(sum < 0) sum += k;
            if(map.containsKey(sum%k)){
                count += map.get(sum%k);
            }
            map.put(sum%k, map.getOrDefault(sum%k,0)+1);
        }
        return count;
    }
}