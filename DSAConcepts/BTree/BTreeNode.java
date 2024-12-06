package BTree;

import java.time.Year;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import javax.swing.LayoutStyle;
import javax.swing.text.AbstractDocument;

public class BTreeNode {
     int t; // minimum degree (defines the range of keys)
     List<Integer> keys; //This is pointer for keys
     List<BTree> children; //this is pointers for children
     boolean isLeaf;

     //constructor
     public BTreeNode(int t, boolean isLeaf){
        this.t = t;
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
     }

     //a function to traverse the B Tree
     void traverse(){
        int i;
        for(i=0; i<keys.size();i++){
            //we will traverse children first before printing the key
            if(!isLeaf){
                children.get(i).traverse();
            }
            System.out.print(keys.get(i) + " ");
        }
        //print for the last sub rooted tree, extreme right one
        if(!isLeaf){
            children.get(i).traverse();
        }
     }

     //Search for a key in the subtree rooted in this node
     BTreeNode search(int key){
        int i = 0;

        //Find the first key greater than or equal to the key
        while(i < keys.size() && key > keys.get(i)){
            //using this we will check the current node pointer, using position of i we can
            //find in subtree node where child to look into
            i++;
        }
 
        if(i < keys.size() && keys.get(i) == key){
            return this;
        }
        
        if(isLeaf){
            return null;
        }

        //go to the appropriate child
        return children.get(i).search(key);
     }
     //function to insert a new key
     public void insertNonFull(int key){
        int i = keys.size() - 1;

        if(isLeaf){
            //insert the key into correct position
            keys.add(0); //temporary space

            while(i >= 0 && key<keys.get(i)){
                //we need to shift the keys forward
                keys.set(i + 1, keys.get(i));
                i--;
            }

            //now we will add the key to the correct position
            keys.set(i+1, key);
        } else{
            //Find the child that will recieve new key
            while(i>=0 && key < keys.get(i)){
                //we are moving from right side
                i--;
            }
            i++;
            // Check if the child is full
            if (children.get(i).keys.size() == 2 * t - 1) {
                // Split the full child
                splitChild(i, children.get(i));

                // Decide which of the two children will receive the new key
                if (key > keys.get(i)) {
                    i++;
                }
            }
            children.get(i).insertNonFull(key);
        }
     }

     //split the child node
     //we only need to spilt when the, child is full means 2t - 1 keys are filled
     void splitChild(int i, BTreeNode node){
        //create a new node
        BTreeNode latest = new BTreeNode(node.t, node.isLeaf);

        //move all the keys from node to latest
        //we need to move last t - 1 nodes
        for(int j=0;j<t -1 ;j++){
            latest.keys.add(node.keys.get(t));
        }

        //if node is not leaf then last t -1 children to latest
        if(!node.isLeaf){
            for(int j = 0; j < t - 1; j++){
                latest.children.add(node.children.remove(t));
            }
        }

        //now we need to insert lastest node to correct position
        children.add(i+1, latest);


        //move the middle key of node to this node
        keys.add(i, node.keys.remove(i - 1));
     }
}
