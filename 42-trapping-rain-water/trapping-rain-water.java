class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax = LeftMax(height);
        rightMax = RightMax(height);

        int water = 0;

        for(int i = 1; i < n-1; i++){
            water += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return water;
    }

    public int[] LeftMax(int[] height){
        int n = height.length;

        int[] result = new int[n];
        result[0] = height[0];
        int leftMax = height[0];
        for(int i = 1; i < n; i++){

            if(height[i] > leftMax){
                leftMax = height[i];
            }

            result[i] = leftMax;
        }
        return result;
    }

    public int[] RightMax(int[] height){
        int n = height.length;

        int[] result = new int[n];
        result[n-1] = height[n-1];
        int rightMax = height[n-1];

        for(int i = n-2; i >= 0; i--){
            if(height[i] > rightMax){
                rightMax = height[i];
            }

            result[i] = rightMax;
        }
        return result;
    }
}