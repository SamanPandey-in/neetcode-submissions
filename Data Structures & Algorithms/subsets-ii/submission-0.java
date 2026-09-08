class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curr, int start) {
        ans.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);
            backtrack(nums, ans, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
