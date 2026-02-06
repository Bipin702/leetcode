class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,candidates,target, new ArrayList<>(),ans);
        return ans;
    }    

    public void solve(int index, int[] candidates, int target,List<Integer> subPart, List<List<Integer>> ans){

        int n = candidates.length;

        if(target == 0){
            ans.add(new ArrayList<>(subPart));
            return;
        }

        if(index == n || target < 0) return;

        subPart.add(candidates[index]);
        solve(index,candidates,target-candidates[index],subPart,ans);
        subPart.remove(subPart.size()-1);
        solve(index+1,candidates,target,subPart,ans);
    }
}