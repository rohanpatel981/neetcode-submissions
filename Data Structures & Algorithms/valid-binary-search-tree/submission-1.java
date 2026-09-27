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
    private void dfs(TreeNode root, List<Integer> l) {
        if (root == null)
            return;
        
        dfs(root.left, l);
        l.add(root.val);
        dfs(root.right, l);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);

        for (int i = 0; i < l.size() - 1; ++i)
            if (l.get(i) >= l.get(i + 1))
                return false;
        
        return true;
    }
}
