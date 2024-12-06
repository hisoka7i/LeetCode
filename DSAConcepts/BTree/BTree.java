package BTree;

public class BTree {
    BTreeNode root; //pointer to root node
    int t; //minimum degree

    public BTree(int t) {
        this.t =  t;
        this.root = null;
    }

    void traverse(){
        if(root != null){
            root.traverse();
        }
    }

    BTreeNode search(int key){
        return root == null ? null : root.search(key);
    }

    void insert(int key){
        if(root == null){
            root = new BTreeNode(key, true);
            root.keys.add(key);
        }else{
            //if the root is null then split it 
            if(root.keys.size() == (2 * t -1 )){
                BTreeNode newRoot = new BTreeNode(t, false);
                newRoot.children.add(root);
                newRoot.splitChild(0, root);

                // Decide which child gets the new key
                int i = (key > newRoot.keys.get(0)) ? 1 : 0;
                newRoot.children.get(i).insertNonFull(key);

                root = newRoot;
            } else {
                root.insertNonFull(key);
            }
        }
    }
}
