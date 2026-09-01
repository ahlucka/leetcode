class Solution {
    public static void main(String[] args) {
        
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return traversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean traversal(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        return traversal(node.left, min, node.val) && traversal(node.right, node.val, max);        
    }
}
