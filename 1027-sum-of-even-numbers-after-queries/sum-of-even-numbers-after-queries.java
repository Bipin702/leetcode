class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        int sumEven = 0;
        for(int num : nums){
            if(num % 2 == 0) sumEven += num;
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int value = queries[i][0];
            int index = queries[i][1];

            if(nums[index] % 2 == 0) sumEven -= nums[index];

            nums[index] += value;

            if(nums[index] % 2 == 0) sumEven += nums[index];
            ans[i] = sumEven;
        }
        return ans;
    }
}