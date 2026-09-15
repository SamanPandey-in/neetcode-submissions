class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;
        int l = 0, maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxf = Math.max(maxf, map.get(c));

            while ((r - l + 1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}