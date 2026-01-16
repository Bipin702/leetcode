class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] unique = new int[n];
        int k = 0;
        unique[k++] = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i-1]){
                unique[k++] = nums[i];
            }
        }
        int left = 0;
        int max = Integer.MIN_VALUE;

        for(int right = 0; right < k; right++){
            while(unique[right] - unique[left] > n-1){
                left++;
            }
            max = Math.max(max,right-left+1);
        }   
        return n-max;
    }
}