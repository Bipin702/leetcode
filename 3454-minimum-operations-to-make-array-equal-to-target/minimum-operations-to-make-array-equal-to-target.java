class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] diff = new int[n];

        for(int i = 0; i < n; i++){
            diff[i] = target[i] - nums[i];
        }

        long ans = Math.abs(diff[0]);

        for(int i = 1; i < n; i++){
            if(diff[i] < 0 && diff[i-1] > 0){
                ans += Math.abs(diff[i]);
            }else if(diff[i] > 0 && diff[i-1] < 0){
                ans += diff[i];
            }else if(Math.abs(diff[i]) - Math.abs(diff[i-1]) >= 0){
                ans += Math.abs(diff[i] - diff[i-1]);
            }
        }
        return ans;
    }
}