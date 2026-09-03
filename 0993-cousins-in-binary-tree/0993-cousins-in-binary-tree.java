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
        int res[] = new int[4];
        helper(x, y, -1, root, 0, res);
        return (res[0] == res[1]) && res[2] != res[3]; 
    }
    public int[] helper(int x, int y, int parent, TreeNode root, int level, int res[]){
        if(root == null){
            return res;
        }
        if(root.val == x){
            res[0] = level;
            res[2] = parent;
        }
        if(root.val == y){
            res[1] = level;
            res[3] = parent;
        }
        helper(x, y, root.val, root.left, level+1, res);
        helper(x, y, root.val, root.right, level+1, res);
        return res;

    }
}