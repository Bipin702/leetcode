class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        int[] ans = new int[m];

        for(int i = 1; i < n; i++){
            nums[i] = nums[i] + nums[i-1];
        }

        for(int i = 0; i < m; i++){
            int result = 0;
            int start = 0;
            int end = n-1;

            while(start <= end){
                int mid = start+(end-start)/2;

                if(nums[mid] <= queries[i]){
                    result = mid+1;
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            ans[i] = result;
        }
        return ans;
    }
}