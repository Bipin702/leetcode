class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int element = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/4){
                element = entry.getKey();
            }
        }
        return element;
    }
}