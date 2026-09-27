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
    private int res;

    private void dfs(TreeNode root, int k, List<Integer> list) {
        if (root == null || k < 0)
            return;

        dfs(root.left, k, list);

        list.add(root.val);
        if (list.size() == k) {
            res = root.val;
            return;
        }

        dfs(root.right, k, list);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k, new ArrayList<>());
        return res;
    }
}
