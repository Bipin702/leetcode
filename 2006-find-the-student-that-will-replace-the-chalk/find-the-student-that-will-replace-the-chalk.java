class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long total = 0;

        for(int chalks : chalk) total += chalks;

        k %= total;

        for(int i = 0; i < n; i++){
            if(k < chalk[i]){
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }
}