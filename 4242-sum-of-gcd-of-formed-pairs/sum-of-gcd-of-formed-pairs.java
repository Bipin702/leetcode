class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int greatest = nums[0];

        int[] prefixGcd = new int[n];

        for(int i = 0; i < n; i++){
            if(nums[i] > greatest) greatest = nums[i];
            prefixGcd[i] = GCD(nums[i],greatest);
        }

        Arrays.sort(prefixGcd);
        int m = prefixGcd.length;
        int i = 0;
        int j = m-1;
        long sum  = 0;
        while(i < j){
            sum += GCD(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }

    public int GCD(int a , int b){
        while(b !=  0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}