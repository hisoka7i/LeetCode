package LeetcodeStreak;
public class a1038 {
    private int sum = 0;
    //Initially we will traverse to the extreme right
    //from there we will come back and save every value into the global sum
    public TreeNode bstToGst(TreeNode root) {
        if(root!= null){
            //we will trverse to right
            bstToGst(root.right);
            //we will save the values sum into the global variable
            sum += root.val;
            //we will update the current node with the sum value 
            root.val = sum;
            //now we will traverse to left
            bstToGst(root.left);
        }
        return root;
    }
}

 class TreeNode {
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
