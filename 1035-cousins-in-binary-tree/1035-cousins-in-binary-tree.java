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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        // Store parent and depth for each node
        Map<Integer, Integer> depth = new HashMap<>();
        Map<Integer, TreeNode> parent = new HashMap<>();
        
        // Perform BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        depth.put(root.val, 0);
        parent.put(root.val, null);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentDepth = depth.get(current.val);
            
            // Process left child
            if (current.left != null) {
                queue.offer(current.left);
                depth.put(current.left.val, currentDepth + 1);
                parent.put(current.left.val, current);
            }
            
            // Process right child
            if (current.right != null) {
                queue.offer(current.right);
                depth.put(current.right.val, currentDepth + 1);
                parent.put(current.right.val, current);
            }
        }
        
        // Check if x and y are cousins
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
    }
}