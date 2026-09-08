class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, candidates, target, 0, new ArrayList<>());
        return list;
    }
    private void backtrack(List<List<Integer>> list, int[] nums, int remain, int start,List<Integer> current) {
        if (remain == 0) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain) {
                break;
            }
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(list, nums, remain - nums[i], i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}