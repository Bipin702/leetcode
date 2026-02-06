class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        solve(nums,ans,sub,set);

        return ans;
    }

    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> sub, HashSet<Integer> set){
        int n = nums.length;

        if(sub.size() == n){
            ans.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!set.contains(nums[i])){
                sub.add(nums[i]);
                set.add(nums[i]);
                solve(nums,ans,sub,set);
                sub.remove(sub.size()-1);
                set.remove(nums[i]);
            }
        }
    }
}