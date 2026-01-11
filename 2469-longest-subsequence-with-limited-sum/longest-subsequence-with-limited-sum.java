class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        int[] ans = new int[m];

        for(int i = 0; i < m; i++){
            int sum = 0;
            int count = 0;
            for(int j = 0; j < n; j++){
                if(sum + nums[j] <= queries[i]){
                    sum += nums[j];
                    count++;
                }else{
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}