import java.util.*;
class a648{
        private Node root;
        private class Node{
            char ch;
            boolean isEnd;
            Node right, left, eq;
            public Node(char ch){
                this.ch=ch;
                this.isEnd = false;
                this.right=null;
                this.left=null;
                this.eq=null;
            }
        }
        public void put(String key){
            root = put(root,key);
        }
        public Node put(Node root,String key){
            if(root==null){
                root = new Node(key.charAt(0));
            }
            else if(key.charAt(0)<root.ch){
                root.left = put(root.left,key);
            }
            else if(key.charAt(0)>root.ch){
                root.right = put(root.right,key);
            }
            else{
                if(key.length()>1){
                    root.eq=put(root.eq,key.substring(1));
                }else{
                    root.isEnd=true;
                }
            }
            return root;
        }
        public String getFirstMatch(String key){
            return getFirstMatch(root,key,0);
        }
        public String getFirstMatch(Node root,String key,int dept){
            if(root==null)return null;
            String str = null;
            if(key.charAt(0)<root.ch){
                str = getFirstMatch(root.left,key,dept);
            }else if(key.charAt(0)>root.ch){
                str = getFirstMatch(root.right,key,dept);
            }else if(root.isEnd){
                return ""+root.ch;
            }else if(dept<(key.length()-1)){
                str = getFirstMatch(root.eq,key.substring(1),dept+1);
                return str == null ? null : root.ch + str;
            }
            return str;
        }
    }
    class Solution{
        public static void main(String[] args){
            List<String> dic = new LinkedList<>();
            dic.add("cat");
            dic.add("bat");
            dic.add("rat");
            String sentence = "the cattle was rattled by the battery";
            ;
            System.out.println(sentence);
            System.out.println(replaceWords(dic,sentence));
        }
        public static String replaceWords(List<String> dictionary, String sentence) {
            if(dictionary==null || dictionary.size()==0)return sentence;
    
            a648 tst = new a648();
            for(String str:dictionary){
                tst.put(str);
            }
            String[] words = sentence.split(" ");
            StringBuilder ss = new StringBuilder();
            for(int i=0;i<words.length;i++){
                String newWord = tst.getFirstMatch(words[i]);
                if(newWord!=null){
                    words[i]=newWord;
                }
                ss.append(words[i]).append(' ');
            }
            ss.deleteCharAt(ss.length()-1);
            return ss.toString();
        }
    }