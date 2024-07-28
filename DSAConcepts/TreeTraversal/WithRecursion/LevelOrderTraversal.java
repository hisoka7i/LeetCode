package TreeTraversal.WithRecursion;

import TreeTraversal.BinaryTree;

public class LevelOrderTraversal {
    public int height(BinaryTree root){
        if(root == null)
            return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);

        return Math.max(left_height, right_height)+1;
    }

    public void printLevelData(BinaryTree root, int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.println(root.data + " ");
        }else if(level > 1){
            printLevelData(root.left, level-1);
            printLevelData(root.right, level-1);
        }
    }

    public void toPrintTreeData(BinaryTree root){
        int height = height(root);
        for(int i=1;i<=height;i++){
            printLevelData(root, i);
        }
    }
}
