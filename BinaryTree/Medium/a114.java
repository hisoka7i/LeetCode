import BinaryTree.TreeNode;

public class a114 {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        TreeNode prev = null;
        while(current != null){
            //now for step one we will move left
            if(current.left != null){
                prev = current.left;
                //now we will move to extreme right of that left
                while(prev.right != null){
                    prev = prev.right;
                }
                //now we will move that, right side of current right under the extreme right of first left
                prev.right = current.right;
                //now we will copy the left tree, from the current to right 
                current.right = current.left;
            }
            current.left = null;
        }
    }
}
