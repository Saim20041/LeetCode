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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        int value = subRoot.val;
        return helper(value, subRoot, root);
        
    }
    public boolean helper(int value, TreeNode subroot, TreeNode root){
        if(root == null || subroot == null) return false;
        if(root.val == value){
            if(check(subroot, root) == true) return true;
        }
        boolean c1 = helper(value, subroot, root.left);
        boolean c2 = helper(value, subroot, root.right);
        return c1 || c2;
    }
    public boolean check(TreeNode subroot, TreeNode root){
        if(subroot == null && root == null){
            return true;
        }
        if(subroot == null || root == null){
            return false;
        }
        if(subroot.val != root.val){
            return false;
        }
        return check(subroot.left, root.left) && check(subroot.right, root.right);

    }

}
