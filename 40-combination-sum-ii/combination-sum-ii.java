class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,candidates,target,ans,new ArrayList<>());

        return ans;
    }

    public void solve(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> subPart){
        if(target == 0){
            ans.add(new ArrayList<>(subPart));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;

            if(candidates[i] > target) break;

            subPart.add(candidates[i]);
            solve(i+1,candidates,target-candidates[i],ans,subPart);
            subPart.remove(subPart.size()-1);
        }
    }
}