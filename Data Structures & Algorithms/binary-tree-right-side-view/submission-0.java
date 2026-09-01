/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode right = null;

            int qLen = q.size();

            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();

                if (node != null) {
                    right = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if (right != null) {
                ans.add(right.val);

            }
        }
        return ans;
    }
}
