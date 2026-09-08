class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(list, candidates, target, 0, new ArrayList<>());
        return list;
    }
    private void backtrack(List<List<Integer>> list, int[] nums, int remain, int start, List<Integer> newList) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(newList));

        else {
            for (int i = start; i < nums.length; i++) {
                newList.add(nums[i]);
                backtrack(list, nums, remain - nums[i], i, newList);
                newList.remove(newList.size() - 1);
            }
        }
    }
}
