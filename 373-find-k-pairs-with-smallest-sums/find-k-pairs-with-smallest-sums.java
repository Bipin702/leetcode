class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (a[0]+a[1]) - (b[0] + b[1])
        );

        for(int i = 0; i < nums1.length; i++){
            pq.offer(new int[]{nums1[i],nums2[0],0});
        }

        while(k-- > 0 && !pq.isEmpty()){
            int[] curr = pq.poll();
            ans.add(Arrays.asList(curr[0],curr[1]));

            int nextIndex = curr[2] + 1;

            if(nextIndex < nums2.length){
                pq.offer(new int[]{curr[0],nums2[nextIndex],nextIndex});
            }
        }
        return ans;
    }
}