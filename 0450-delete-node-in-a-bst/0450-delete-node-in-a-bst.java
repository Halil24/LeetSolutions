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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key>root.val){
            root.right = deleteNode(root.right,key);
        }else if(key<root.val){
            root.left = deleteNode(root.left,key);
        }else{
            if((root.right==null)&&(root.left==null)){
                return null;
            }
            if(root.right==null){
                return root.left;
            } 
            if(root.left==null){
                return root.right;
            }

            TreeNode current = root.right;
            while(current.left!=null){
                current=current.left;
            }

            root.val=current.val;
            root.right = deleteNode(root.right,current.val);
        }
        return root;
    }
}