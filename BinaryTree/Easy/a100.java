package BinaryTree.Easy;

import com.sun.tools.javac.resources.legacy;

import BinaryTree.TreeNode;
import java.awt.desktop.QuitHandler;

public class a100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean finalvalue = isReallySame(p, q);
        return finalvalue;
    }

    public boolean isReallySame(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }

        return (isReallySame(p.left, q.left) && isReallySame(p.right, q.right));
    }
}
