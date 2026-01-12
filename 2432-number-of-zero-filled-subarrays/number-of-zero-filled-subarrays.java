class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n =nums.length;
        long result = 0;
        int i = 0;
        while(i < n){
            long l = 0;
            if(nums[i] == 0){
                while(i < n && nums[i] == 0){
                    i++;
                    l++;
                }
            }else{
                i++;
            }
            result += l*(l+1)/2;
        }
        return result;
    }
}