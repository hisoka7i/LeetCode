package BinaryTree.Hard;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Codec {
    public static final String Marker = "M";
    int m = 1;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> serialized = new ArrayList<>();
        serializeHelper(root, serialized);
        return String.join(",", serialized);
    }

    //using pre order traversal we going to fill tree, and null we are going to mark with M + count;
    public void serializeHelper(TreeNode root, List<String> stream){
        if(root == null){
            stream.add(Marker + m);
            m++;
            return;
        }

        stream.add(String.valueOf(root.val));
        //pre order traversal
        serializeHelper(root.left, stream);
        serializeHelper(root.right, stream);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //we are going to split the string on the basis of ","
        List<String> stream = new ArrayList<>(Arrays.asList(data.split(",")));

        //now we will reverse the collection, since we want to take data out from the start
        Collections.reverse(stream);

        TreeNode node = deserializeHelper(stream);
        return node;
    }

    TreeNode deserializeHelper(List<String> stream){
        //we need to pop the last element from the list
        String rootVal = stream.remove(stream.size() - 1);

        if(rootVal.charAt(0) == Marker.charAt(0)){
            return null;
        }

        //now we need to create the root
        TreeNode root = new TreeNode(Integer.valueOf(rootVal));

        root.left = deserializeHelper(stream);
        root.right = deserializeHelper(stream);

        return root;
    }
}
