class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return gcd(nums[0],nums[n-1]);
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}