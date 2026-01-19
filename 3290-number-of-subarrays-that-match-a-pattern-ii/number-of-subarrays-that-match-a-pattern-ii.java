class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) nums2[i] = 1;
            else if (nums[i] == nums[i + 1]) nums2[i] = 0;
            else nums2[i] = -1;
        }

        int[] lps = new int[m];
        computeLps(pattern, lps);

        int j = 0; 
        int k = 0; 
        int count = 0;

        while (j < nums2.length) {
            if (nums2[j] == pattern[k]) {
                j++;
                k++;
            }

            if (k == m) {
                count++;
                k = lps[k - 1]; 
            } else if (j < nums2.length && nums2[j] != pattern[k]) {
                if (k != 0) {
                    k = lps[k - 1];
                } else {
                    j++;
                }
            }
        }

        return count;
    }

    public static void computeLps(int[] pat, int[] lps) {
        int m = pat.length;
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
