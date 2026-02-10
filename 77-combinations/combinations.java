class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = new int[n];

        for(int i = 0; i < n; i ++){
            nums[i] = i+1;
        }
        List<Integer> sub = new ArrayList<>();
        solve(0,nums,k,ans,sub);
        return ans;
    }

    public void solve(int index, int[] nums, int k, List<List<Integer>> ans, List<Integer> sub){
        if(k == 0){
            ans.add(new ArrayList<>(sub));
            return;
        }
        if(index == nums.length) return;

        sub.add(nums[index]);
        solve(index+1,nums,k-1,ans,sub);
        sub.remove(sub.size()-1);
        solve(index+1,nums,k,ans,sub);
    }
}