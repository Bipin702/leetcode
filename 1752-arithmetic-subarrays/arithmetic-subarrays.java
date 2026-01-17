class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int range1 = l[i];
            int range2 = r[i];

            ans.add(Arithmetic(nums,range1,range2));
        }
        return ans;
    }

    public boolean Arithmetic(int[] nums, int range1, int range2){
        int len = range2-range1+1;
        int[] temp = new int[len];

        for(int i = 0; i < len; i++){
            temp[i] = nums[range1+i];
        }
        Arrays.sort(temp);

        int diff = temp[1] - temp[0];

        for(int i = 2; i < len; i++){
            if(temp[i] - temp[i-1] != diff){
                return false;
            }
        }
        return true;
    }
}