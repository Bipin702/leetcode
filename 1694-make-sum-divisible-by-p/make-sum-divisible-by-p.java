class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int total = 0;

        for (int num : nums) {
            total = (total + num) % p;
        }

        int target = total;
        if (target == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int curr = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;
            int need = (curr - target + p) % p;

            if (map.containsKey(need)) {
                minLen = Math.min(minLen, i - map.get(need));
            }

            map.put(curr, i);
        }

        if (minLen == Integer.MAX_VALUE || minLen == n) {
            return -1;
        }

        return minLen;
    }
}
