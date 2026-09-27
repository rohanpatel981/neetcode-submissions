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
    HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

    private void getParentInfo(TreeNode root, TreeNode prev) {
        if (root == null)
            return;
        parentMap.put(root, prev);
        getParentInfo(root.left, root);
        getParentInfo(root.right, root);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getParentInfo(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; ++i) {
                TreeNode curr = queue.poll();

                if (curr.val > 100) {
                    curr.val -= 100;
                    return curr;
                }
                
                if (parentMap.get(curr) != null) {
                    queue.offer(parentMap.get(curr));
                }

                curr.val += 100;
            }
        }

        return null;
    }
}
