class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        Arrays.sort(changed);

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : changed) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int[] ans = new int[n / 2];
        int index = 0;

        for (int num : changed) {
            if (map.get(num) == 0) continue;

            if (num == 0) {
                if (map.get(0) < 2) return new int[0];
                ans[index++] = 0;
                map.put(0, map.get(0) - 2);
            } else {
                int twice = num * 2;
                if (!map.containsKey(twice) || map.get(twice) == 0) {
                    return new int[0];
                }
                ans[index++] = num;
                map.put(num, map.get(num) - 1);
                map.put(twice, map.get(twice) - 1);
            }
        }

        return ans;
    }
}
