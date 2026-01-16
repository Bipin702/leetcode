class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] nums3 = new int[n+m];
        int i = 0, j = 0, k = 0;

        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                nums3[k] = nums1[i];
                i++;
            }else{
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < n){
            nums3[k] = nums1[i];
            i++;
            k++;
        }

        while(j < m){
            nums3[k] = nums2[j];
            j++;
            k++;
        }

        double median = 0;

        int len = nums3.length;

        if (len % 2 != 0) {
            return nums3[len / 2];
        } else {
            return (nums3[len / 2 - 1] + nums3[len / 2]) / 2.0;
        }
    }
}