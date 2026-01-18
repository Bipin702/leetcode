class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            int count = map.getOrDefault(num,0);

            if(count == result.size()){
                result.add(new ArrayList<>());
            }

            result.get(count).add(num);
            map.put(num,count+1);
        }
        return result;
    }
}