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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null && node.right != null){
                    if((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x)){
                    return false;
                    }
                }
                

                if(node.right != null){
                    if(node.right.val == x){
                        foundX = true;
                    }
                    if(node.right.val == y){
                        foundY = true;
                    }
                    queue.add(node.right);
                }
                if(node.left != null){
                    if(node.left.val == x){
                        foundX = true;
                    }
                    if(node.left.val == y){
                        foundY = true;
                    }
                    queue.add(node.left);

                }
            }
            if(foundX == true && foundY == true){
                return true;
            }
            if(foundX == true || foundY == true){
                return false;
            }
        }
        return false;
    }
}