class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = findFirst(nums,target);
        int last = findLast(nums,target);

        return new int[]{first,last};
    }

    public int findFirst(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                result = mid;
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }

    public int findLast(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                result = mid;
                start = mid+1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }
}