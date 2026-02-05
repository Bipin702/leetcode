class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int shift = nums[i] % n;
            int index = ((i + shift) % n + n) % n;
            res[i] = nums[index];
        }
        return res;
    }
}
