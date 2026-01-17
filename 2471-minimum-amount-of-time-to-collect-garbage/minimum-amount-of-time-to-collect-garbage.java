class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int m = travel.length;
    
        int glassCount = 0;
        int lastGlassHouse = -1;
        int paperCount = 0;
        int lastPaperHouse = -1;
        int metalCount = 0;
        int lastMetalHouse = -1;
        int[] prefixSum = new int[m+1];
        prefixSum[0] = 0;

        for(int i = 1; i <= m; i++){
            prefixSum[i] = prefixSum[i-1] + travel[i-1];
        }
        for(int i = 0; i < n; i++){
            String s = garbage[i];
            for(char ch : s.toCharArray()){
                if(ch == 'G'){
                    glassCount++;
                    lastGlassHouse = i;
                }
                if(ch == 'M'){
                    metalCount++;
                    lastMetalHouse = i;
                }
                if(ch == 'P'){
                    paperCount++;
                    lastPaperHouse = i;
                }
            }
        }

        int totalTime = 0;
        
        totalTime += metalCount + paperCount + glassCount;

        if(lastMetalHouse != -1) totalTime += prefixSum[lastMetalHouse];
        if(lastPaperHouse != -1) totalTime += prefixSum[lastPaperHouse];
        if(lastGlassHouse != -1) totalTime += prefixSum[lastGlassHouse];

        return totalTime;
    }
}