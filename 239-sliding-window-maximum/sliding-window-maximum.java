class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if(n == 0 || k == 0) return new int[0];
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n-k+1];

        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i >= k-1){
                result[i-k+1]  = arr[dq.peek()];
            }
        }
        return result;
    }
}