class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int pivot = findPivot(nums);

        int idx = Binary(nums,0,pivot-1,target);

        if(idx != -1) return idx;

        idx = Binary(nums,pivot,n-1,target);

        return idx;
    }

    public int findPivot(int[] nums){
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start < end){
            int mid = start + (end-start)/2;

            if(nums[mid] > nums[end]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return end;
    }

    public int Binary(int[] nums, int start, int end, int target){
        int index = -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return index;
    }
}