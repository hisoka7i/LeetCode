
public class Trie {
    static final int ALPHABET_SIZE  = 26;
    public static class TrieNode{
        TrieNode[] childNodes = new TrieNode[ALPHABET_SIZE];
        boolean is_end;
        public TrieNode(){
            is_end = false;
            for(int i=0;i<ALPHABET_SIZE;i++){
                childNodes[i] = null;
            }
        }
   }
   static TrieNode root;
   public static void insert(String key){
    int level;
    int dept = key.length();
    int index;
    TrieNode currentNode = root;
    for(level=0; level<dept; level++){
        index = key.charAt(level)-'a';
        if(currentNode.childNodes[index]==null){
            currentNode.childNodes[index]=new TrieNode();
        }
        currentNode = currentNode.childNodes[index];
    }
    currentNode.is_end=true;
   }

   public static boolean search(String key){
    int level;
    int dept = key.length();
    int index;
    TrieNode rootNode = root;
    for(level=0; level<dept;level++){
        index=key.charAt(level)-'a';
        if(rootNode.childNodes[index]==null){
            return false;}
        rootNode = rootNode.childNodes[index];
    }
    return true;
   }
   public static void main(String args[])
   {
       // Input keys (use only 'a' through 'z' and lower case)
       String keys[] = {"the", "a", "there", "answer", "any",
                        "by", "bye", "their"};
     
       String output[] = {"Not present in trie", "Present in trie"};
     
     
       root = new TrieNode();
     
       // Construct trie
       int i;
       for (i = 0; i < keys.length ; i++)
           insert(keys[i]);
     
       // Search for different keys
       if(search("the") == true)
           System.out.println("the --- " + output[1]);
       else System.out.println("the --- " + output[0]);
        
       if(search("these") == true)
           System.out.println("these --- " + output[1]);
       else System.out.println("these --- " + output[0]);
        
       if(search("their") == true)
           System.out.println("their --- " + output[1]);
       else System.out.println("their --- " + output[0]);
        
       if(search("thaw") == true)
           System.out.println("thaw --- " + output[1]);
       else System.out.println("thaw --- " + output[0]);
       
   }
}
