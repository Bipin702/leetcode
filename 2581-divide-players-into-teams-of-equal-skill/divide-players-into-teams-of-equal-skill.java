class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        Arrays.sort(skill);

        int target = skill[0] + skill[n-1];
        long chemistrySum = 0;
        int left = 0;
        int right = n-1;

        while(left < right){
            int sum = skill[left] + skill[right];

            if(sum != target) return -1;

            chemistrySum += (long) skill[left] * skill[right];
            left++;
            right--;
        }

        return chemistrySum;
    }
}