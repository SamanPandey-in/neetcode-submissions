class Solution {
    public int findDuplicate(int[] nums) {
        int l = nums[0], r = nums[0];

        while (true) {
            l = nums[l];
            r = nums[nums[r]];
            if (l == r) break;
        }

        int slow = nums[0];
        while (slow != l) {
            l = nums[l];
            slow = nums[slow];
        }
        return slow;
    }
}