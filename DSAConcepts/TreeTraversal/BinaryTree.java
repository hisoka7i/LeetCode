package TreeTraversal;

public class BinaryTree {
    public int data;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree sibling;
    public BinaryTree(int data, BinaryTree left, BinaryTree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public BinaryTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
    public BinaryTree(){
        this.left = null;
        this.right = null;
    }
}
