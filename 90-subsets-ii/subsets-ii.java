class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num : nums){
            int n = ans.size();
            for(int i = 0; i < n; i++){
                List<Integer> inner = new ArrayList<>(ans.get(i));
                inner.add(num);
                if(!ans.contains(inner)){
                    ans.add(inner);
                }
            }
        }
        return ans;
    }
}