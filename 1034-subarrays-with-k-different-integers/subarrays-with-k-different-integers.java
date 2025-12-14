class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return SubAtMost(nums,k) - SubAtMost(nums,k-1);
    }

    public int SubAtMost(int[] nums,int k){
        int n = nums.length;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            while(map.size() > k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += (i-left+1);
        } 
        return count;
    }
}