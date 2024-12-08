package BinarySearchTree.Medium;


public class a98 {
    public boolean isValidBST(TreeNode root) {
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;
        return isBST(root,null,null);
    }
    public boolean isBST(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;
        
        if((min != null && min >= root.val) || !(max != null && max <= root.val)){
            return false;
        }

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}