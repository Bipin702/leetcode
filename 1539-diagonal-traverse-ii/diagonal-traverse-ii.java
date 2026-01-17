class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int n = nums.size();
        int total = 0;
        int maxdiagonal = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < nums.get(i).size(); j++){
                int diagonal = i+j;
                map.putIfAbsent(i+j,new ArrayList<>());
                map.get(i+j).add(0,nums.get(i).get(j));
                maxdiagonal = Math.max(diagonal, maxdiagonal);
                total++;
            }
        }

        int[] result = new int[total];
        int index = 0;

        for(int d = 0; d <= maxdiagonal; d++){
            if(map.containsKey(d)){
                for(int val : map.get(d)){
                    result[index++] = val;
                }
            }
        }
        return result;
    }
}