class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            int number = groupSizes[i];
            map.putIfAbsent(number,new ArrayList<>());
            map.get(number).add(i);

            if(map.get(number).size() == number){
                result.add(new ArrayList<>(map.get(number)));
                map.get(number).clear();
            }
        }
        return result;
    }
}