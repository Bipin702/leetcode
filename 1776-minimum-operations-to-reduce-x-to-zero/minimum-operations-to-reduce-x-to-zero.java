class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int sum = 0;
        for(int num : nums) sum += num;

        int target = sum-x;
        if(target == 0) return n;
        int maxLen = -1;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int currentSum = 0;

        for(int i =0; i < n; i++){
            currentSum += nums[i];

            int remaining = currentSum - target;

            if(map.containsKey(remaining)){
                maxLen = Math.max(maxLen, i- map.get(remaining));
            }

            if(!map.containsKey(currentSum)){
                map.put(currentSum,i);
            }
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
}