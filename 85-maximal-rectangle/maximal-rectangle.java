class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[] height = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int area = LargestArea(height);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

    public int LargestArea(int[] arr){
        int n = arr.length;
        int maxA = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i <= n; i++){
            int curH = (i == n) ? 0 : arr[i];
            while(!st.isEmpty() && curH <= arr[st.peek()]){
                int heightIndex = st.pop();
                int h = arr[heightIndex];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxA = Math.max(maxA, h * width);
            }
            st.push(i);
        }
        return maxA;
    }
}