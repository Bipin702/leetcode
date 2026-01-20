class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        map.put(0,1);
        int sum = 0;
        for(int num : nums){
            sum += (num % 2);

            if(map.containsKey(sum-goal)){
                count += map.get(sum-goal);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
     return count;
    }

    public int CountAtMost(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            sum += (nums[right] %2);

            while(sum > goal){
                sum -= (nums[left]%2);
                left++;
            }
            count += (right-left+1);
        }
        return count;
    }
}