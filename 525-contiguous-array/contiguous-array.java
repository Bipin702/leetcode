class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int zero = 0;
        int ones = 0;
        int result = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0) zero++;
            else ones++;

            int diff = zero - ones;

            if(diff == 0){
                result = Math.max(result,i+1);
            }

            if(!map.containsKey(diff)){
                map.put(diff,i);
            }else{
                int idx = map.get(diff);
                int len = i - idx;
                result = Math.max(result,len);
            }
        }
        return result;
    }
}